package com.magenta.distance.controller;

import com.magenta.distance.service.CityService;
import com.magenta.distance.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    DistanceService distanceService;

    @GetMapping("/all")
    public HashMap<Long, String> findAll() {
        return cityService.findAll();
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadXmlFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Файл не был загружен");
        }

        try {
            InputStream inputStream = new BufferedInputStream(file.getInputStream());
            cityService.loadCitiesFromXml(inputStream);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<List<Double>> calculateDistance(@RequestBody List<Request> requests) {
        List<Double> distances = new ArrayList<>();
        for (Request request : requests) {
            String type = request.getType();
            long fromCity = request.getFromCity();
            long toCity = request.getToCity();

            double distance;
            switch (type) {
                case "CROWFLIGHT" -> distance = distanceService.calculateDistance(fromCity, toCity);
                case "DISTANCE_MATRIX" -> distance = distanceService.getDistance(fromCity, toCity);
                case "All" -> {
                    distances.add(distanceService.calculateDistance(fromCity, toCity));
                    distance = distanceService.getDistance(fromCity, toCity);
                }
                default -> throw new IllegalArgumentException("Неверный тип рассчёта");
            }
            distances.add(distance);
        }
        return ResponseEntity.ok(distances);
    }
}
