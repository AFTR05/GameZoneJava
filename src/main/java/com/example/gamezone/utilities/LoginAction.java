package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Administrator;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;

import java.util.HashSet;

public class LoginAction {
    public Boolean adminLogin(String name,String password,ModelFactoryController mfc){
        if(name.equals(mfc.getArcade().getAdministratorService().getAdministrator().getName())&& password.equals(mfc.getArcade().getAdministratorService().getAdministrator().getPassword())){
            return true;
        }
        return false;
    }

    public String DefaultLogin(String name, String password, ModelFactoryController mfc){
        if (mfc.getArcade().getSercherObject().getClient(name,password,mfc.getArcade().getClientService().getListClients())!=null){
           return "client";
        }
        if (mfc.getArcade().getSercherObject().getEmployee(name,password,mfc.getArcade().getEmployeeService().getListEmployee())!=null){
            return "employee";
        }
        return "";
    }
}
