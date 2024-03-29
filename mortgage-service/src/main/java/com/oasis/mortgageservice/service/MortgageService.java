package com.oasis.mortgageservice.service;

import com.oasis.domain.mortgage.CalcResult;
import com.oasis.mortgageservice.LogFormatter;
import com.oasis.utils.MathsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.oasis.mortgageservice.Constants.INCOME_MULTIPLE_LOWER_BOUND;
import static com.oasis.mortgageservice.Constants.INCOME_MULTIPLE_UPPER_BOUND;
import static com.oasis.mortgageservice.calculators.PaymentsCalculator.*;
import static com.oasis.mortgageservice.calculators.LoanCalculator.*;

@Slf4j
@Service
public class MortgageService {

    public double calculateMonthlyMortgagePayment(double principal, double yearlyInterestRate, int loanTermInYears) {
        double monthlyPayment = MathsUtils.toTwoDP(
                monthlyMortgagePaymentCalculation(
                        principal,
                        yearlyInterestRateToMonthly(yearlyInterestRate),
                        yearlyTermLengthToMonthly(loanTermInYears)
                )
        );
        log.info(LogFormatter.logMonthlyPaymentCalculation(principal, yearlyInterestRate, loanTermInYears, monthlyPayment));
        return monthlyPayment;
    }

    public double calculateTotalRepaymentAmount(double monthlyPayment, int loanTermInYears) {
        double totalRepayment = MathsUtils.toTwoDP(
                totalRepaymentCalculation(monthlyPayment, yearlyTermLengthToMonthly(loanTermInYears))
        );
        log.info(LogFormatter.logTotalRepaymentCalculation(monthlyPayment, loanTermInYears, totalRepayment));
        return totalRepayment;
    }

    public CalcResult calculateApproxLoanAmount(double income1, double income2, double totalMonthlyExpenses) {
        double netIncomeAfterExpenses = (income1 + income2 - (totalMonthlyExpenses * 12));
        CalcResult res = new CalcResult(
                jointLoanAmountCalculator(netIncomeAfterExpenses, INCOME_MULTIPLE_LOWER_BOUND),
                jointLoanAmountCalculator(netIncomeAfterExpenses, INCOME_MULTIPLE_UPPER_BOUND)
        );
        log.info(LogFormatter.logApproxLoanResult(income1, income2, totalMonthlyExpenses, netIncomeAfterExpenses, res.getLowResult(), res.getHighResult()));
        return res;
    }
}
