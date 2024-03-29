package com.oasis.mortgageservice;

public class LogFormatter {

    public static String logMonthlyPaymentCalculation(double principal, double yearlyInterestRate, int loanTermInYears, double monthlyPayment) {
        return "<Calculating Monthly Mortgage Payments>\n" +
               "    Loan Amount:           " + principal + "\n" +
               "    Interest Rate:         " + yearlyInterestRate * 100 + "%\n" +
               "    Term Length (years):   " + loanTermInYears + "\n" +
               "Monthly Repayments: " + monthlyPayment;
    }

    public static String logTotalRepaymentCalculation(double monthlyPayment, int loanTermInYears, double totalRepayment) {
        return "<Calculating Total Repayment Amount>\n" +
               "    Monthly Payments:      " + monthlyPayment + "\n" +
               "    Term Length (years):   " + loanTermInYears + "\n" +
               "Total Repayment Amount: " + totalRepayment;
    }

    public static String logApproxLoanResult(double income1, double income2, double totalMonthlyExpenses, double netIncomeAfterExpenses, double lowRes, double highRes) {
        return "<Calculating Approximate Loan Amount>\n" +
               "    Income 1:             " + income1 + "\n" +
               "    Income 2:             " + income2 + "\n" +
               "    Total Expenses:       " + totalMonthlyExpenses * 12 + "\n" +
               "    Net Income:           " + netIncomeAfterExpenses + "\n" +
               "Approximate Loan Amount: <LOW: " + lowRes + "> - <HIGH: " + highRes + ">";
    }
}
