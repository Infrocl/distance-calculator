package com.magenta.distance.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.magenta.distance.entity.City;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "cities")
public class CityList {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "city")
    private List<City> cities;
}
