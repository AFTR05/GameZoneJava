package com.example.gamezone.validations;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.exceptions.CloneException;

public class CloneValidator {
    public Boolean verifyClone(ModelFactoryController mfc, String name){
        if(mfc.getArcade().getVerificatorClone().verifyName(name,mfc.getArcade().getAdministratorService().getAdministrator().getName(),mfc.getArcade().getClientService().getListClients(),mfc.getArcade().getEmployeeService().getListEmployee())) {
            return true;
        }else {
            try {
                throw new CloneException("The name already exists");
            }catch (CloneException ce){
                mfc.getArcade().getAlertGenerator().alertError(ce.getMessage(),null);
                return false;
            }
        }
    }
}
