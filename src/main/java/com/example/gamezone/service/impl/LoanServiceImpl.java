package com.example.gamezone.service.impl;

import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Loan;
import com.example.gamezone.service.LoanService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LoanServiceImpl implements LoanService {
    private ArrayList<Loan> listLoans;
    private Arcade arcade;

    @Override
    public void createLoan(LocalDateTime beginDate, LocalDateTime endDate, Client client, Attraction attraction) {
        listLoans.add(new Loan(beginDate,endDate,client,attraction));
        Client client1=arcade.getSercherObject().getClient(client.getName(),client.getPassword(),arcade.getClientService().getListClients());
        client1.setAmountLoan(client1.getAmountLoan()+1);
        arcade.getAlertGenerator().alertInformation("The loan cost is $"+attraction.getPrice(),"Success");
    }

    public LoanServiceImpl(Arcade arcade) {
        this.arcade = arcade;
    }

    public ArrayList<Loan> getListLoans() {
        return listLoans;
    }

    public void setListLoans(ArrayList<Loan> listLoans) {
        this.listLoans = listLoans;
    }
}
