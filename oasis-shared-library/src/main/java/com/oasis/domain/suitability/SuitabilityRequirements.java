package com.oasis.domain.suitability;

import java.util.Optional;

public class SuitabilityRequirements {
    private int targetBudget;
    private Optional<RoomRequirements> roomRequirements;
    private Optional<LocationLists> locationLists;
    private boolean needsGarden;

    public SuitabilityRequirements(int targetBudget, Optional<RoomRequirements> roomRequirements, Optional<LocationLists> locationLists, boolean needsGarden) {
        this.targetBudget = targetBudget;
        this.roomRequirements = roomRequirements;
        this.locationLists = locationLists;
        this.needsGarden = needsGarden;
    }
}
