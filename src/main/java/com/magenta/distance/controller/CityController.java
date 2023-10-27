package com.magenta.distance.controller;

import com.magenta.distance.pojo.CityPojo;
import com.magenta.distance.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/all")
    public HashMap<Long, String> findAll() {
        return cityService.findAll();
    }
}
