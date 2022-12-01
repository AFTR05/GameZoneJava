package com.example.gamezone.validations;

import com.example.gamezone.exceptions.MinimumSalaryException;
import com.example.gamezone.exceptions.PriceException;
import com.example.gamezone.service.impl.Arcade;

public class PriceValidator {
    private final Arcade arcade;

    public PriceValidator(Arcade arcade) {
        this.arcade = arcade;
    }

    public Boolean validatePrice(String price){
        try {
            if (Double.parseDouble(price)>0){
                System.out.println("cumple");
                return true;
            }else {
                throw new PriceException("The price is without value");
            }
        }catch (NumberFormatException nfe){
            arcade.getAlertGenerator().alertError("That is not a number","Price error");
            return false;
        }catch (PriceException pe){
            arcade.getAlertGenerator().alertError(pe.getMessage(),"Price error");
            return false;
        }
    }

}
