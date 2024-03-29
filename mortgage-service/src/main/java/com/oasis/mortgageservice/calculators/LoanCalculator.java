package com.oasis.mortgageservice.calculators;

public class LoanCalculator {
    /**
     * When calculating how much to loan to a customer, the following is generally used
     * Maximum Mortgage Amount = (Combined Income - Combined Outgoings) * Income Multiple
     * @param net (total income - total expenses)
     * @param incomeMultiple (typically between 3x and 4.5x annual salary)
     * @return CalcResult(double lowResult, double highResult)
     */
    public static double jointLoanAmountCalculator(double net, double incomeMultiple) {
        return net * incomeMultiple;
    }
}
