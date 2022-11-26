package com.example.gamezone.validations;

import com.example.gamezone.exceptions.MinimumSalaryException;
import com.example.gamezone.service.impl.Arcade;

public class SalaryValidation {
    private final Arcade arcade;
    public SalaryValidation(Arcade arcade){
        this.arcade=arcade;
    }
    public Boolean numberValidation(String salary){
        try {
            if (Double.parseDouble(salary)>=1000000){
                return true;
            }else {
                throw new MinimumSalaryException("The salary is below of the minimum salary");
            }
        }catch (NumberFormatException nfe){
            arcade.getAlertGenerator().alertError("That is not a number","Salary error");
            return false;
        }catch (MinimumSalaryException mse){
            arcade.getAlertGenerator().alertError(mse.getMessage(),"Salary error");
            return false;
        }



    }
}
