package com.example.gamezone.service.impl;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Client;
import com.example.gamezone.service.PersonService;

import java.util.HashSet;
import java.util.Set;

public class ClientServiceImpl implements PersonService {
    private HashSet<Client> listClients;

    public HashSet<Client> getListClients() {
        return listClients;
    }

    public void setListClients(HashSet<Client> listClients) {
        this.listClients = listClients;
    }

    @Override
    public void createPerson(String name, String email, String password) {
        listClients.add(new Client(name,email,password));
    }

    @Override
    public void deletePerson(String name, String password,ModelFactoryController mfc) {

    }
}
