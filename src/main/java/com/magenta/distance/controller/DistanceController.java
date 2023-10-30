package com.magenta.distance.controller;

import com.magenta.distance.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/distance")
public class DistanceController {
    @Autowired
    DistanceService distanceService;

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
