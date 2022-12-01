package com.example.gamezone.validations;

import com.example.gamezone.DTOs.AttractionDTO;
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

    public Boolean validateEmpty4Space(String name,String code,String price,String type){
        if (!(name.equals("")||code.equals("")||price.equals("")||type.equals(""))){
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

    public Boolean validateDeleteAttraction(AttractionDTO attractionDTO,String name,String code,String type,String price){
        if (attractionDTO.getName().equals(name)&& attractionDTO.getCode().equals(code) && attractionDTO.getCategory().equals(type) && String.valueOf(attractionDTO.getPrice()).equals(price)){
            return true;
        }else {
            try {
                throw new InputException("the information of the fields has been modified");
            }catch (InputException ie){
                arcade.getAlertGenerator().alertError(ie.getMessage(), "Modified information");
                return false;
            }
        }
    }

}
