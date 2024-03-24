package com.oasis.domain.property;

import lombok.Data;

@Data
public class Rooms {
    private int bedrooms;
    private int bathrooms;
    private boolean hasEnsuite;

    public Rooms() {}

    public Rooms(int bedrooms, int bathrooms, boolean hasEnsuite) {
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.hasEnsuite = hasEnsuite;
    }
}
