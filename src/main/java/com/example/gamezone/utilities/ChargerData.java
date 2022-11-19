package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;

import java.io.IOException;

public class ChargerData {
    public void chargeData(ModelFactoryController mfc){
        try {
            mfc.getArcade().getAdministratorService().setAdministrator(mfc.getArcade().getPersistenceAdmin().chargeAdmin());
            mfc.getArcade().getClientService().setListClients(mfc.getArcade().getPersistenceClient().chargeClient());
            mfc.getArcade().getEmployeeService().setListEmployee(mfc.getArcade().getPersistenceEmployee().chargeEmployee());
        }catch (IOException ioe){

        }
    }
}
