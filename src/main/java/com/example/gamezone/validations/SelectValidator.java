package com.example.gamezone.validations;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Person;

public class SelectValidator {
    public Boolean validatePerson(Person personSelected, ModelFactoryController mfc){
        if (personSelected==null){
            mfc.getArcade().getAlertGenerator().alertError("The person is not selected","No selection");
            return false;
        }else return true;

    }
}
