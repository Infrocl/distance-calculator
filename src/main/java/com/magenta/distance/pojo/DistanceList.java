package com.magenta.distance.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.magenta.distance.entity.Distance;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "distances")
public class DistanceList {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "distance")
    private List<Distance> distances;
}
