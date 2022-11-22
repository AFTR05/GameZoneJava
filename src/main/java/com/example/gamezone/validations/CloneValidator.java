package com.example.gamezone.validations;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.exceptions.CloneException;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Person;

public class CloneValidator {
    public Boolean verifyClone(ModelFactoryController mfc, String name, Person mePerson){
        if(mfc.getArcade().getVerificatorClone().verifyName(name,mfc.getArcade().getAdministratorService().getAdministrator().getName(),mfc.getArcade().getClientService().getListClients(),mfc.getArcade().getEmployeeService().getListEmployee())) {
            return true;
        }else if (name.equals(mePerson.getName())){
            return true;
        }else{
            try {
                throw new CloneException("The name already exists");
            }catch (CloneException ce){
                mfc.getArcade().getAlertGenerator().alertError(ce.getMessage(),null);
                return false;
            }
        }
    }

    public Boolean verifySign(ModelFactoryController mfc,String name){
        if(mfc.getArcade().getVerificatorClone().verifyName(name,mfc.getArcade().getAdministratorService().getAdministrator().getName(),mfc.getArcade().getClientService().getListClients(),mfc.getArcade().getEmployeeService().getListEmployee())) {
            return true;
        }else{
            try {
                throw new CloneException("The name already exists");
            }catch (CloneException ce){
                mfc.getArcade().getAlertGenerator().alertError(ce.getMessage(),null);
                return false;
            }
        }

    }


}
