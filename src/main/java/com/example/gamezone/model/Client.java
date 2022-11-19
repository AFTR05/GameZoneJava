package com.example.gamezone.model;

public class Client extends Person{
    int amountLoan;

    public Client(String name,String email,String password) {
        super(name,password,email);
    }

    public Client(){
        super();
    }

    public int getAmountLoan() {
        return amountLoan;
    }

    public void setAmountLoan(int amountLoan) {
        this.amountLoan = amountLoan;
    }
}
