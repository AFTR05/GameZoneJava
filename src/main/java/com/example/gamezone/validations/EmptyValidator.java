package com.example.gamezone.validations;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.exceptions.CloneException;
import com.example.gamezone.exceptions.InputException;
import com.example.gamezone.model.Person;
import com.example.gamezone.service.impl.Arcade;

public class EmptyValidator {
    private final Arcade arcade;

    public EmptyValidator(Arcade arcade) {
        this.arcade = arcade;
    }

    public Boolean validateEmpty3Space(String name, String email, String password){
        if(!(name == "" || email == "" || password == "")) {
            return true;
        }else {
            try {
                throw new InputException("Information is missing");
            }catch (InputException ie){
                arcade.getAlertGenerator().alertError(ie.getMessage(),"Lack of information");
                return false;
            }
        }
    }

    public Boolean validateEmptyNumber(String salary){
        if(!(salary=="")){
            return true;
        }else {
            try {
                throw new InputException("Information is missing");
            }catch (InputException ie){
                arcade.getAlertGenerator().alertError(ie.getMessage(), "Lack of information");
                return false;
            }
        }
    }

}
