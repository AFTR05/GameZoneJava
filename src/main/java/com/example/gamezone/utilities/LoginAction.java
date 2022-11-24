package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Administrator;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.service.impl.Arcade;

import java.util.HashSet;

public class LoginAction {
    private final Arcade arcade;
    public LoginAction(Arcade arcade){
        this.arcade=arcade;
    }
    public Boolean adminLogin(String name,String password){
        if(name.equals(arcade.getAdministratorService().getAdministrator().getName())&& password.equals(arcade.getAdministratorService().getAdministrator().getPassword())){
            return true;
        }
        return false;
    }

    public String DefaultLogin(String name, String password){
        if (arcade.getSercherObject().getPerson(name,password,arcade.getClientService().getListClients())!=null){
           return "client";
        }
        if (arcade.getSercherObject().getPerson(name,password,arcade.getEmployeeService().getListEmployee())!=null){
            return "employee";
        }
        return "";
    }
}
