package com.magenta.distance.repository;

import com.magenta.distance.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<ProjectIdAndName> findAllProjectedBy();
}
