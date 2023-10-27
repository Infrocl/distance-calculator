package com.magenta.distance.controller;

import com.magenta.distance.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
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
}
