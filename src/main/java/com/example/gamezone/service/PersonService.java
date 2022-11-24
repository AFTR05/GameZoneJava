package com.example.gamezone.service;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Client;
import com.example.gamezone.service.impl.Arcade;

import java.util.HashSet;

public interface PersonService {
    void createPerson(String name,String email,String password);
    void deletePerson(String name, String password);

}
