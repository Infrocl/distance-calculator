package com.magenta.distance.controller;

import com.magenta.distance.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

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
}
