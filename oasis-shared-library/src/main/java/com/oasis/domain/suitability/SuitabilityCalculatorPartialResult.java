package com.oasis.domain.suitability;

public class SuitabilityCalculatorPartialResult {
    private double priceSuitability;
    private double locationSuitability;
    private double publicTransportSuitability;
    private double roomsSuitability;
    private double sizeSuitability;
    private double gardenSuitability;

    public SuitabilityCalculatorPartialResult(double priceSuitability, double locationSuitability, double publicTransportSuitability, double roomsSuitability, double sizeSuitability, double gardenSuitability) {
        this.priceSuitability = priceSuitability;
        this.locationSuitability = locationSuitability;
        this.publicTransportSuitability = publicTransportSuitability;
        this.roomsSuitability = roomsSuitability;
        this.sizeSuitability = sizeSuitability;
        this.gardenSuitability = gardenSuitability;
    }

    public int numberOfFields() {
        return 6;
    }
}
