package com.magenta.distance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Longitude", nullable = false)
    private double longitude;

    @Column(name = "Latitude", nullable = false)
    private double latitude;

    @OneToMany(mappedBy = "fromCity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Distance> fromCity;

    @OneToMany(mappedBy = "toCity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Distance> toCity;
}
