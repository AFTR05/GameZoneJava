package com.example.gamezone.service.impl;

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
}
