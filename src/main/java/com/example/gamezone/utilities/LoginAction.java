package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Administrator;

public class LoginAction {
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    public Boolean adminLogin(String name,String password){
        if(name.equals(Administrator.ADMINISTRATOR.getName())&& password.equals(Administrator.ADMINISTRATOR.getPassword()) ){
            return true;
        }
        return false;
    }

    public String DefaultLogin(String name,String password){
        if (mfc.getArcade().getSercherObject().getClient(name,password,mfc.getArcade().getClientService().getListClients())!=null){
           return "client";
        }
        if (mfc.getArcade().getSercherObject().getEmployee(name,password,mfc.getArcade().getEmployeeService().getListEmployee())!=null){
            return "employee";
        }
        return null;
    }
}
