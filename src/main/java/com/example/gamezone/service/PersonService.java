package com.example.gamezone.service;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Client;

import java.util.HashSet;

public interface PersonService {
    void createPerson(String name,String email,String password);
    void deletePerson(String name, String password,ModelFactoryController mfc);

}
