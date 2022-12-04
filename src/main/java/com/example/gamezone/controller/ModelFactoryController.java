package com.example.gamezone.controller;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.TypeAttraction;
import com.example.gamezone.service.ModelFactoryService;
import com.example.gamezone.service.impl.Arcade;

import java.time.LocalDateTime;

public class ModelFactoryController implements ModelFactoryService {



    private Arcade arcade;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public Arcade getArcade() {
        return arcade;
    }

    public void setArcade(Arcade arcade) {
        this.arcade = arcade;
    }

    public ModelFactoryController() {
        arcade = new Arcade();
    }

    @Override
    public void createLoan(LocalDateTime beginDate, LocalDateTime endDate, Client client, Attraction attraction) {
        arcade.getLoanService().createLoan(beginDate, endDate, client, attraction);
    }

    @Override
    public void createClient(String name, String email, String password) {
        arcade.getClientService().createPerson(name, email, password);
    }
    @Override
    public void createEmployee(String name, String email, String password) {
        arcade.getEmployeeService().createPerson(name, email, password);
    }
    @Override
    public void createAdmin(String name, String email, String password) {
        arcade.getAdministratorService().createPerson(name, email, password);
    }

    @Override
    public void deleteEmployee(String name, String password) {
        arcade.getEmployeeService().deletePerson(name,password);
    }

    @Override
    public void createAttraction(String name, String code, Double price, TypeAttraction type) {
        arcade.getAttractionService().createAttraction(name, code, price, type);
    }

    @Override
    public void deleteAttraction(String name, String code, Double price, TypeAttraction type) {
        arcade.getAttractionService().deleteAttraction(name, code, price, type);
    }

    @Override
    public void updateAttraction(String name, String code, Double price, TypeAttraction type, AttractionDTO attractionSelected) {
        arcade.getAttractionService().updateAttraction(name, code, price, type, attractionSelected);
    }
}
