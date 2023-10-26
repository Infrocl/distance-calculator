package com.magenta.distance.pojo;

import com.magenta.distance.entity.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityPojo {
    private long id;
    private double longitude;
    private double latitude;

    public static CityPojo fromEntity(City city) {
        CityPojo pojo = new CityPojo();
        pojo.setId(city.getId());
        pojo.setLatitude(city.getLatitude());
        pojo.setLongitude(city.getLongitude());
        return pojo;
    }

    public static City toEntity(CityPojo pojo) {
        City city = new City();
        city.setId(pojo.getId());
        city.setLatitude(pojo.getLatitude());
        city.setLongitude(pojo.getLongitude());
        return city;
    }
}
