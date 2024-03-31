package com.oasis.domain.mortgage;

public class Expenses {
    private double loans;
    private double rent;
    private double bills;
    private double food;
    private double other;
    private double total;

    public Expenses() {}

    public Expenses(double loans, double rent, double bills, double food, double other) {
        this.loans = loans;
        this.rent = rent;
        this.bills = bills;
        this.food = food;
        this.other = other;
        this.total = loans + rent + bills + food + other;
    }

    public double getLoans() {
        return loans;
    }

    public void setLoans(double loans) {
        this.loans = loans;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getBills() {
        return bills;
    }

    public void setBills(double bills) {
        this.bills = bills;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
