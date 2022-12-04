package com.example.gamezone.service;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.TypeAttraction;

import java.time.LocalDateTime;

public interface ModelFactoryService {
    void createLoan(LocalDateTime beginDate, LocalDateTime endDate, Client client, Attraction attraction);
    void createClient(String name,String email,String password);
    void createEmployee(String name,String email,String password);
    void createAdmin(String name,String email,String password);
    void deleteEmployee(String name, String password);
    void createAttraction(String name, String code, Double price, TypeAttraction type);
    void deleteAttraction(String name, String code, Double price, TypeAttraction type);
    void updateAttraction(String name, String code, Double price, TypeAttraction type, AttractionDTO attractionSelected);
}
