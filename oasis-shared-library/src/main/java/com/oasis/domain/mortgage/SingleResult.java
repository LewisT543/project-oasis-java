package com.oasis.domain.mortgage;

public class SingleResult {
    private int loanAmount;
    private int repaymentTerm;
    private double rate;
    private int monthlyPayments;
    private AffordabilityResult affordability;

    public SingleResult(int loanAmount, int repaymentTerm, double rate, int monthlyPayments, AffordabilityResult affordability) {
        this.loanAmount = loanAmount;
        this.repaymentTerm = repaymentTerm;
        this.rate = rate;
        this.monthlyPayments = monthlyPayments;
        this.affordability = affordability;
    }
}
