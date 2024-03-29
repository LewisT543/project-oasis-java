package com.oasis.mortgageservice.controller;

import com.oasis.domain.mortgage.CalcResult;
import com.oasis.mortgageservice.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4173")
@RequestMapping("/api/mortgage")
public class MortgageController {

    private final MortgageService mortgageService;

    @Autowired
    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @GetMapping("/getMonthlyPayment")
    public ResponseEntity<Double> getMonthlyPayments(@RequestParam double principal, @RequestParam double yearlyInterestRate, @RequestParam int loanTermInYears) {
        return new ResponseEntity<>(mortgageService.calculateMonthlyMortgagePayment(principal, yearlyInterestRate, loanTermInYears), HttpStatus.OK);
    }

    @GetMapping("/getTotalRepaymentAmount")
    public ResponseEntity<Double> getTotalRepayment(@RequestParam double monthlyPayment, @RequestParam int loanTermInYears) {
        return new ResponseEntity<>(mortgageService.calculateTotalRepaymentAmount(monthlyPayment, loanTermInYears), HttpStatus.OK);
    }

    @GetMapping("/getApproxLoanAmount")
    public ResponseEntity<CalcResult> getApproxLoan(@RequestParam double income1,@RequestParam double income2, @RequestParam double totalMonthlyExpenses) {
        return new ResponseEntity<>(mortgageService.calculateApproxLoanAmount(income1, income2, totalMonthlyExpenses), HttpStatus.OK);
    }

}
