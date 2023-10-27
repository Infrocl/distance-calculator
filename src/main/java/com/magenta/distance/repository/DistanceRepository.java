package com.magenta.distance.repository;

import com.magenta.distance.entity.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistanceRepository extends JpaRepository<Distance, Long> {
    @Query(value = "select d.distance from Distance d where d.From_city_id in (:fId, :tId) and d.To_City_id in (:fId, :tId)", nativeQuery = true)
    double findDistanceByCityId(@Param("fId") long fromCityId, @Param("tId") long toCityId);
}
