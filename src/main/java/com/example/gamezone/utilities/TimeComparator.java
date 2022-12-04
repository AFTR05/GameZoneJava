package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.LoanDTO;

import java.time.LocalDate;

public class TimeComparator {
    public Boolean localDateComparison(LocalDate localDate,String generalDate){
        if (localDate.isAfter(LocalDate.parse(generalDate))||localDate.isEqual(LocalDate.parse(generalDate))){
            return false;
        }else return true;
    }


}
