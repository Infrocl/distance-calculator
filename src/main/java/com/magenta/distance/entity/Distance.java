package com.magenta.distance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Distance")
@Getter
@Setter
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "From_city_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private City fromCity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "To_city_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private City toCity;

    private double distance;
}
