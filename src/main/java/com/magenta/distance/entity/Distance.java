package com.magenta.distance.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Distance")
@Getter
@Setter
@JacksonXmlRootElement(localName = "distance")
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "From_city_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JacksonXmlProperty(localName = "from_city")
    private City fromCity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "To_city_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JacksonXmlProperty(localName = "to_city")
    private City toCity;

    @JacksonXmlProperty(localName = "distance")
    private double distance;
}
