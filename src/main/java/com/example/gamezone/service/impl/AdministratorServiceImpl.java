package com.example.gamezone.service.impl;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Administrator;
import com.example.gamezone.service.PersonService;

public class AdministratorServiceImpl implements PersonService{
    private Administrator administrator;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void createPerson(String name, String email, String password) {
        administrator.setName(name);
        administrator.setEmail(email);
        administrator.setPassword(password);
    }

    @Override
    public void deletePerson(String name, String password,ModelFactoryController mfc) {

    }
}
