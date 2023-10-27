package com.magenta.distance.service;

import com.magenta.distance.repository.CityRepository;
import com.magenta.distance.repository.ProjectIdAndName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public HashMap<Long, String> findAll() {
        HashMap<Long, String> map = new HashMap<>();
        for (ProjectIdAndName projection : cityRepository.findAllProjectedBy()) {
            map.put(projection.getId(), projection.getName());
        }
        return map;
    }
}
