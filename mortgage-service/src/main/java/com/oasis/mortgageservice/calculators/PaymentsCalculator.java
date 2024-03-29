package com.oasis.mortgageservice.calculators;

public class PaymentsCalculator {

    public static double totalRepaymentCalculation(double monthlyPayment, int loanTermInMonths) {
        return monthlyPayment * loanTermInMonths;
    }

    /**
     * Calculates the monthly mortgage costs given a principal, a rate and a term length.
     * @param principal (the initial amount of the loan)
     * @param monthlyInterestRate (annual interest rate divided by 12 and expressed as a decimal)
     * @param loanTermInMonths (loan term in months)
     * @return Monthly mortgage payment (as a double to 2 decimal places)
     */
    public static double monthlyMortgagePaymentCalculation(double principal, double monthlyInterestRate, int loanTermInMonths) {
        double numerator = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths);
        double denominator = Math.pow(1 + monthlyInterestRate, loanTermInMonths) - 1;
        return numerator / denominator;
    }

    public static double yearlyInterestRateToMonthly(double yearlyInterestRate) {
        return yearlyInterestRate / 12;
    }

    public static int yearlyTermLengthToMonthly(int loanTermYears) {
        return loanTermYears * 12;
    }
}
