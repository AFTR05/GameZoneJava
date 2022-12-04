package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.LoanDTO;
import com.example.gamezone.model.Loan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TimeComparator {
    public Boolean localDateComparison(LocalDate localDate,String generalDate){
        if (localDate.isAfter(LocalDate.parse(generalDate))||localDate.isEqual(LocalDate.parse(generalDate))){
            return false;
        }else return true;
    }

    public ArrayList<Loan> editForTime(ArrayList<Loan> loans){
        if (loans!=null){
            ArrayList<Loan> listLoanFilter;
            listLoanFilter=(ArrayList<Loan>) loans.stream().filter(x->LocalDateTime.now().isBefore(x.getBeginDate())).collect(Collectors.toList());
            return listLoanFilter;
        }else{
            return null;
        }
    }


}
