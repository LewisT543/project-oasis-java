package com.oasis.domain.mortgage;

public class MortgageSettings {
    private int repaymentTerm;
    private double interestRate;
    private double[] loanToSalaryRange;
    private boolean usingNet;

    public MortgageSettings(int repaymentTerm, double interestRate, double[] loanToSalaryRange, boolean usingNet) {
        this.repaymentTerm = repaymentTerm;
        this.interestRate = interestRate;
        this.loanToSalaryRange = loanToSalaryRange;
        this.usingNet = usingNet;
    }
}
