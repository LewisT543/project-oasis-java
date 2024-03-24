package com.oasis.domain.suitability;

public class SuitabilityCalculatorResult {
    private SuitabilityCalculatorPartialResult suitabilities;
    private double overallSuitability;

    public SuitabilityCalculatorResult(SuitabilityCalculatorPartialResult suitabilities, double overallSuitability) {
        this.suitabilities = suitabilities;
        this.overallSuitability = overallSuitability;
    }
}
