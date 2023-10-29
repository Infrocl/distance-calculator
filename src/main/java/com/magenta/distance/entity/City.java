package com.magenta.distance.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@JacksonXmlRootElement(localName = "city")
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name", nullable = false)
    @JacksonXmlProperty(localName = "name")
    private String name;

    @Column(name = "Longitude", nullable = false)
    @JacksonXmlProperty(localName = "longitude")
    private double longitude;

    @Column(name = "Latitude", nullable = false)
    @JacksonXmlProperty(localName = "latitude")
    private double latitude;

    @OneToMany(mappedBy = "fromCity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Distance> fromCity;

    @OneToMany(mappedBy = "toCity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Distance> toCity;
}
