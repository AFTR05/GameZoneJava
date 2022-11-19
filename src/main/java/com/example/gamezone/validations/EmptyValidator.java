package com.example.gamezone.validations;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.exceptions.CloneException;
import com.example.gamezone.exceptions.InputException;

public class EmptyValidator {
    public Boolean validateEmpty3Space(ModelFactoryController mfc,String name, String email, String password){
        if(!(name == null || email == null || password == null)) {
            return true;
        }else {
            try {
                throw new InputException("Information is missing");
            }catch (InputException ie){
                mfc.getArcade().getAlertGenerator().alertError(ie.getMessage(),"Lack of information");
                return false;
            }
        }
    }
}
