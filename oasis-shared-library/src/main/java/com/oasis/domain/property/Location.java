package com.oasis.domain.property;

import lombok.Data;

@Data
public class Location {
    private String road;
    private String region;
    private String city;
    private String postcode;

    public Location() {}

    public Location(String road, String region, String city, String postcode) {
        this.road = road;
        this.region = region;
        this.city = city;
        this.postcode = postcode;
    }
}
