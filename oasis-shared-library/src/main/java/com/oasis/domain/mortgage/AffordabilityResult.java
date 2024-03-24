package com.oasis.domain.mortgage;

public class AffordabilityResult {
    private double loanPctOfNet;
    private double leftOverPct;
    private int monthlyCosts;
    private int leftoverAmount;

    public AffordabilityResult(double loanPctOfNet, double leftOverPct, int monthlyCosts, int leftoverAmount) {
        this.loanPctOfNet = loanPctOfNet;
        this.leftOverPct = leftOverPct;
        this.monthlyCosts = monthlyCosts;
        this.leftoverAmount = leftoverAmount;
    }
}
