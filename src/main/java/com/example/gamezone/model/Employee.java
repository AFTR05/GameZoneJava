package com.example.gamezone.model;

public class Employee extends Person{
    private double totalIncome;

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Employee(String name, String password, String email) {
        super(name, password, email);
    }

    public Employee(){
        super();
    }
}
