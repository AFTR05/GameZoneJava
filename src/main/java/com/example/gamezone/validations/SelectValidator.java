package com.example.gamezone.validations;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.DTOs.EmployeeDTO;
import com.example.gamezone.DTOs.LoanDTO;
import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Attraction;
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


    public Boolean validateAttraction(Attraction attraction){
        if (attraction==null){
            arcade.getAlertGenerator().alertError("The attraction is not selected","No selection");
            return false;
        }else return true;
    }


    public Boolean validateLoanDTO(LoanDTO loanDTOSelected){
        if (loanDTOSelected==null){
            arcade.getAlertGenerator().alertError("The schedule is not selected","No selection");
            return false;
        }else return true;
    }

    public Boolean validateEmployeeDTO(EmployeeDTO employeeDTOSelected){
        if (employeeDTOSelected==null){
            arcade.getAlertGenerator().alertError("The Employee is not selected","No selection");
            return false;
        }else return true;
    }

    public Boolean validateAttractionDTo(AttractionDTO attractionDTO){
        if (attractionDTO==null){
            arcade.getAlertGenerator().alertError("The attraction is not selected","No selection");
            return false;
        }else return true;
    }
}
