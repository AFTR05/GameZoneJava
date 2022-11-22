package com.example.gamezone.DTOs;

public class ClientDTO {
    private String name;
    private String email;
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

    public ClientDTO(String name, int amountLoan,String email) {
        this.name = name;
        this.amountLoan = amountLoan;
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientDTO() {
    }
}
