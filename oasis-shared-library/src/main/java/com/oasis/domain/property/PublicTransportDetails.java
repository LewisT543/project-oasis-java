package com.oasis.domain.property;

import lombok.Data;

import java.util.List;

@Data
public class PublicTransportDetails {
    private List<StationDetail> stations;

    public PublicTransportDetails() {}

    public PublicTransportDetails(List<StationDetail> stations) {
        this.stations = stations;
    }
}
