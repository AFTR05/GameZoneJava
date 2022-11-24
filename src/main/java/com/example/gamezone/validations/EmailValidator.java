package com.example.gamezone.validations;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.exceptions.CloneEmailException;
import com.example.gamezone.exceptions.InputException;
import com.example.gamezone.exceptions.RuteEmailException;
import com.example.gamezone.model.EmailRute;
import com.example.gamezone.service.impl.Arcade;

public class EmailValidator {
    private final Arcade arcade;
    public EmailValidator(Arcade arcade){
        this.arcade=arcade;
    }
    public Boolean ruteVerification(String email){
        try {
            if (email.split("@")[1].equals(EmailRute.YAHOO.getEmailRute()) || email.split("@")[1].equals(EmailRute.GOOGLE.getEmailRute()) || email.split("@")[1].equals(EmailRute.OUTLOOK.getEmailRute()) || email.split("@")[1].equals(EmailRute.HOTMAIL.getEmailRute())){
                return true;
            }else {
                throw new RuteEmailException("That is not a email");
            }
        }catch (ArrayIndexOutOfBoundsException aiobe){
            arcade.getAlertGenerator().alertError("That is not a email","Not valid Email");
            return false;
        }catch (RuteEmailException ree){
            arcade.getAlertGenerator().alertError(ree.getMessage(), "Not valid Email");
            return false;
        }
    }

    public Boolean cloneEmail(String email){
        if (arcade.getVerificatorClone().verifyEmail(email, arcade.getClientService().getListClients()) && arcade.getVerificatorClone().verifyEmail(email, arcade.getEmployeeService().getListEmployee()) && !email.equals(arcade.getAdministratorService().getAdministrator().getEmail())){
            return true;
        }else {
            try {
                throw new CloneEmailException("That email already exists");
            }catch (CloneEmailException cee){
                arcade.getAlertGenerator().alertError(cee.getMessage(),"Not valid Email");
                return false;
            }
        }
    }

    public Boolean verifyEmail(String email){
        return ruteVerification(email) && cloneEmail(email);
    }
}
