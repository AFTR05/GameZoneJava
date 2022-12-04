package com.example.gamezone.validations;

import com.example.gamezone.exceptions.TimeException;
import com.example.gamezone.model.Person;
import com.example.gamezone.service.impl.Arcade;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeValidator {
    private Arcade arcade;

    public TimeValidator(Arcade arcade) {
        this.arcade = arcade;
    }

    public Boolean validateDatePicker(DatePicker datePicker){
        if ((datePicker.getValue()==null)){
            arcade.getAlertGenerator().alertError("The date is not selected","Date error");
            return false;
        }else if (arcade.getTimeComparator().localDateComparison(datePicker.getValue(),arcade.getTimeConverter().localDateTimeToGeneral(LocalDateTime.now()))){
            try {
                throw new TimeException("The date is before now");
            }catch (TimeException te){
                arcade.getAlertGenerator().alertError(te.getMessage(),"Date error");
                return false;
            }
        }else {
            return true;
        }

    }

}
