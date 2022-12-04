package com.example.gamezone.model;

import java.time.LocalDateTime;

public class Loan {
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Client client;
    private Attraction attraction;

    public Loan(){
        super();
    }

    public Loan(LocalDateTime beginDate, LocalDateTime endDate, Client client, Attraction attraction) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.client = client;
        this.attraction = attraction;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
