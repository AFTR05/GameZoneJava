package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.service.impl.Arcade;

import java.io.IOException;

public class ChargerData {
    private final Arcade arcade;
    public ChargerData(Arcade arcade){
        this.arcade=arcade;
    }
    public void chargeData(){
        try {
            arcade.getAdministratorService().setAdministrator(arcade.getPersistenceAdmin().chargeAdmin());
            arcade.getClientService().setListClients(arcade.getPersistenceClient().chargeClient());
            arcade.getEmployeeService().setListEmployee(arcade.getPersistenceEmployee().chargeEmployee());
        }catch (IOException ioe){

        }
    }
}
