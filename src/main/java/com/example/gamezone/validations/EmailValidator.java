package com.example.gamezone.validations;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.exceptions.CloneEmailException;
import com.example.gamezone.exceptions.InputException;
import com.example.gamezone.exceptions.RuteEmailException;
import com.example.gamezone.model.EmailRute;

public class EmailValidator {
    public Boolean ruteVerification(String email, ModelFactoryController mfc){
        try {
            if (email.split("@")[1].equals(EmailRute.YAHOO.getEmailRute()) || email.split("@")[1].equals(EmailRute.GOOGLE.getEmailRute()) || email.split("@")[1].equals(EmailRute.OUTLOOK.getEmailRute()) || email.split("@")[1].equals(EmailRute.HOTMAIL.getEmailRute())){
                return true;
            }else {
                throw new RuteEmailException("That is not a email");
            }
        }catch (ArrayIndexOutOfBoundsException aiobe){
            mfc.getArcade().getAlertGenerator().alertError("That is not a email","Not valid Email");
            return false;
        }catch (RuteEmailException ree){
            mfc.getArcade().getAlertGenerator().alertError(ree.getMessage(), "Not valid Email");
            return false;
        }
    }

    public Boolean cloneEmail(ModelFactoryController mfc,String email){
        if (mfc.getArcade().getVerificatorClone().verifyEmail(email, mfc.getArcade().getClientService().getListClients()) && mfc.getArcade().getVerificatorClone().verifyEmail(email, mfc.getArcade().getEmployeeService().getListEmployee()) && !email.equals(mfc.getArcade().getAdministratorService().getAdministrator().getEmail())){
            return true;
        }else {
            try {
                throw new CloneEmailException("That email already exists");
            }catch (CloneEmailException cee){
                mfc.getArcade().getAlertGenerator().alertError(cee.getMessage(),"Not valid Email");
                return false;
            }
        }
    }

    public Boolean verifyEmail(String email,ModelFactoryController mfc){
        return ruteVerification(email, mfc) && cloneEmail(mfc, email);
    }
}
