package com.oasis.domain.suitability;

import java.util.Optional;

public class RoomRequirements {
    private Optional<Integer> minBedrooms;
    private Optional<Integer> minBathrooms;
    private boolean needsEnSuite;

    public RoomRequirements(Optional<Integer> minBedrooms, Optional<Integer> minBathrooms, boolean needsEnSuite) {
        this.minBedrooms = minBedrooms;
        this.minBathrooms = minBathrooms;
        this.needsEnSuite = needsEnSuite;
    }
}
