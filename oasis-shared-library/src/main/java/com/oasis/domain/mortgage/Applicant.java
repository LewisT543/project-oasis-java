package com.oasis.domain.mortgage;

public class Applicant {
    private int salary;
    private int netMonthly;
    private Expenses expenses;

    public Applicant(int salary, int netMonthly, Expenses expenses) {
        this.salary = salary;
        this.netMonthly = netMonthly;
        this.expenses = expenses;
    }
}
