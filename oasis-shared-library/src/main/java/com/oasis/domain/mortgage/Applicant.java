package com.oasis.domain.mortgage;

public class Applicant {
    private String id;
    private double salary;
    private double netMonthly;
    private Expenses expenses;

    public Applicant() {}

    public Applicant(String id, double salary, double netMonthly, Expenses expenses) {
        this.id = id;
        this.salary = salary;
        this.netMonthly = netMonthly;
        this.expenses = expenses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getNetMonthly() {
        return netMonthly;
    }

    public void setNetMonthly(double netMonthly) {
        this.netMonthly = netMonthly;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }
}
