package com.magenta.distance.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Request {
    private String type;
    private long fromCity;
    private long toCity;
}