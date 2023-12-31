package com.magenta.distance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.magenta.distance.entity.City;
import com.magenta.distance.entity.Distance;
import com.magenta.distance.pojo.*;
import com.magenta.distance.repository.CityRepository;
import com.magenta.distance.repository.DistanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DistanceService {
    private final CityRepository cityRepository;
    private final DistanceRepository distanceRepository;

    public double calculateDistance(long fromCityId, long toCityId) {
        CityPojo fromCity = CityPojo.fromEntity(cityRepository.findById(fromCityId).orElseThrow());
        CityPojo toCity = CityPojo.fromEntity(cityRepository.findById(toCityId).orElseThrow());
        double fromCityLatitude = Math.toRadians(fromCity.getLatitude());
        double fromCityLongitude = Math.toRadians(fromCity.getLongitude());
        double toCityLatitude = Math.toRadians(toCity.getLatitude());
        double toCityLongitude = Math.toRadians(toCity.getLongitude());
        double deltaLatitude = toCityLatitude - fromCityLatitude;
        double deltaLongitude = toCityLongitude - fromCityLongitude;
        double earthRadius = 6371;
        double a = Math.pow(Math.sin(deltaLatitude / 2), 2) + Math.cos(fromCityLatitude) * Math.cos(toCityLatitude) * Math.pow(Math.sin(deltaLongitude / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }

    public double getDistance(long fromCityId, long toCityId) {
        return distanceRepository.findDistanceByCityId(fromCityId, toCityId);
    }

    public void loadFromXml(String dataType, InputStream inputStream) {
        ObjectMapper objectMapper = new XmlMapper();
        try {
            if (dataType.equals("City")) {
                CityList cityList = objectMapper.readValue(inputStream, CityList.class);
                List<City> cities = cityList.getCities();
                cityRepository.saveAll(cities);
            } else if (dataType.equals("Distance")) {
                DistanceList distanceList= objectMapper.readValue(inputStream, DistanceList.class);
                List<Distance> distances = distanceList.getDistances();
                distanceRepository.saveAll(distances);
            } else {
                throw new IllegalArgumentException("Неверный тип данных");
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при парсинге XML", e);
        }
    }
}
