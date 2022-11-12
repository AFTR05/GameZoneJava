package com.example.gamezone.DTOs;

public class ClientDTO {
    private String name;
    private int amountLoan;
    public int getAmountLoan() {
        return amountLoan;
    }

    public void setAmountLoan(int amountLoan) {
        this.amountLoan = amountLoan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientDTO(String name, int amountLoan) {
        this.name = name;
        this.amountLoan = amountLoan;
    }
}
