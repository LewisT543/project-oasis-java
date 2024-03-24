package com.oasis.domain.property;

import com.oasis.domain.property.enums.StationType;
import lombok.Data;

@Data
public class StationDetail {
    private String name;
    private StationType stationType;
    private double distanceFromProperty;

    public StationDetail() {}

    public StationDetail(String name, StationType stationType, double distanceFromProperty) {
        this.name = name;
        this.stationType = stationType;
        this.distanceFromProperty = distanceFromProperty;
    }
}
