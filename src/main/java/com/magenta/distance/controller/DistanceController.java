package com.magenta.distance.controller;

import com.magenta.distance.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/distance")
public class DistanceController {
    @Autowired
    DistanceService distanceService;

    @GetMapping("/{fromId}/{toId}/crowflight")
    public double calculateDistance(@PathVariable long fromId, @PathVariable long toId) {
        return distanceService.calculateDistance(fromId, toId);
    }

    @GetMapping("/{fromId}/{toId}/matrix")
    public double getDistance(@PathVariable long fromId, @PathVariable long toId) {
        return distanceService.getDistance(fromId, toId);
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadXmlFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Файл не был загружен");
        }

        try {
            InputStream inputStream = new BufferedInputStream(file.getInputStream());
            distanceService.loadDistancesFromXml(inputStream);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }
}
