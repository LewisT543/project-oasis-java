package com.oasis.domain.mortgage;

public class Expenses {
    private int loans;
    private int rent;
    private int bills;
    private int food;
    private int other;
    private int total;

    public Expenses(int loans, int rent, int bills, int food, int other) {
        this.loans = loans;
        this.rent = rent;
        this.bills = bills;
        this.food = food;
        this.other = other;
        this.total = loans + rent + bills + other;
    }
}
