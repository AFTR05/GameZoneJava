package com.example.gamezone.validations;

import com.example.gamezone.DTOs.EmployeeDTO;
import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Person;
import com.example.gamezone.service.impl.Arcade;

public class SelectValidator {
    private final Arcade arcade;
    public SelectValidator(Arcade arcade){
        this.arcade=arcade;
    }
    public Boolean validatePerson(Person personSelected){
        if (personSelected==null){
            arcade.getAlertGenerator().alertError("The person is not selected","No selection");
            return false;
        }else return true;

    }

    public Boolean validateEmployeeDTO(EmployeeDTO employeeDTOSelected){
        if (employeeDTOSelected==null){
            arcade.getAlertGenerator().alertError("The Employee is not selected","No selection");
            return false;
        }else return true;
    }
}
