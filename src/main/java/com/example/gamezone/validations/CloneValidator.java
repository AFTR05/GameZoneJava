package com.example.gamezone.validations;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.exceptions.CloneException;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Person;
import com.example.gamezone.service.impl.Arcade;

public class CloneValidator {
    private final Arcade arcade;
    public CloneValidator(Arcade arcade){
        this.arcade=arcade;
    }
    public Boolean verifyClone( String name, Person mePerson){
        if(arcade.getVerificatorClone().verifyName(name,arcade.getAdministratorService().getAdministrator().getName(),arcade.getClientService().getListClients(),arcade.getEmployeeService().getListEmployee())) {
            return true;
        }else if (name.equals(mePerson.getName())){
            return true;
        }else{
            try {
                throw new CloneException("The name already exists");
            }catch (CloneException ce){
                arcade.getAlertGenerator().alertError(ce.getMessage(),null);
                return false;
            }
        }
    }

    public Boolean verifySign(String name){
        if(arcade.getVerificatorClone().verifyName(name,arcade.getAdministratorService().getAdministrator().getName(),arcade.getClientService().getListClients(),arcade.getEmployeeService().getListEmployee())) {
            return true;
        }else{
            try {
                throw new CloneException("The name already exists");
            }catch (CloneException ce){
                arcade.getAlertGenerator().alertError(ce.getMessage(),null);
                return false;
            }
        }
    }

    public Boolean verifyCode(String code){
        if (arcade.getVerificatorClone().verifyCode(code,arcade.getAttractionService().getAttractions())){
            return true;
        }else {
            try {
                throw new CloneException("The code already exists");
            }catch (CloneException ce){
                arcade.getAlertGenerator().alertError(ce.getMessage(),"Code fail");
                return false;
            }
        }
    }

    public Boolean verifyCodeWithSelection(String code, AttractionDTO attractionDTO){
        if (arcade.getVerificatorClone().verifyCodeWithSelection(code,arcade.getAttractionService().getAttractions(), attractionDTO)){
            return true;
        }else {
            try {
                throw new CloneException("The code already exists");
            }catch (CloneException ce){
                arcade.getAlertGenerator().alertError(ce.getMessage(),"Code fail");
                return false;
            }
        }
    }


}
