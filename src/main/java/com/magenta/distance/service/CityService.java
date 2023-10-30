package com.magenta.distance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.magenta.distance.entity.City;
import com.magenta.distance.pojo.CityList;
import com.magenta.distance.repository.CityRepository;
import com.magenta.distance.repository.ProjectIdAndName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

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
