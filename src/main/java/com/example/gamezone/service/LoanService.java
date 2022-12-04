package com.example.gamezone.service;

import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;

import java.time.LocalDateTime;

public interface LoanService {
    void createLoan(LocalDateTime beginDate, LocalDateTime endDate, Client client, Attraction attraction);
}
