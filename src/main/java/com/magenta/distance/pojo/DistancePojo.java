package com.magenta.distance.pojo;

import com.magenta.distance.entity.Distance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistancePojo {
    private long id;
    private CityPojo fromCity;
    private CityPojo toCity;
    private double distance;

    public static DistancePojo fromEntity(Distance distance) {
        DistancePojo pojo = new DistancePojo();
        pojo.setId(distance.getId());
        pojo.setFromCity(CityPojo.fromEntity(distance.getFromCity()));
        pojo.setToCity(CityPojo.fromEntity(distance.getToCity()));
        pojo.setDistance(distance.getDistance());
        return pojo;
    }

    public static Distance toEntity(DistancePojo pojo) {
        Distance distance = new Distance();
        distance.setId(pojo.getId());
        distance.setDistance(pojo.getDistance());
        distance.setFromCity(CityPojo.toEntity(pojo.getFromCity()));
        distance.setToCity(CityPojo.toEntity(pojo.getToCity()));
        return distance;
    }
}
