package com.example.gamezone.utilities;

import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Loan;
import com.example.gamezone.service.impl.Arcade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterTimeLister {
    private Arcade arcade;

    public FilterTimeLister(Arcade arcade) {
        this.arcade = arcade;
    }

    public ArrayList<Loan> limitToDay(ArrayList<Loan> loans, String generalDate){
        if (loans!=null){
            ArrayList<Loan> listLoanFilter;
            listLoanFilter=(ArrayList<Loan>) loans.stream().filter(x->generalDate.equals(arcade.getTimeConverter().localDateTimeToGeneral(x.getBeginDate()))).collect(Collectors.toList());
            return listLoanFilter;
        }else {
            return null;
        }

    }

    public ArrayList<Loan> limitToAttraction(ArrayList<Loan> loans, Attraction attraction){
        if (loans!=null){
            ArrayList<Loan> listLoanFilter;
            listLoanFilter=(ArrayList<Loan>) loans.stream().filter(x->attraction.getCode().equals(x.getAttraction().getCode())).collect(Collectors.toList());
            return listLoanFilter;
        }else{
            return null;
        }
    }

    public ArrayList<Loan> limitAll(ArrayList<Loan> loans, Attraction attraction,String generalDate){
        ArrayList<Loan> listLoanFilter;
        listLoanFilter=limitToDay(loans,generalDate);
        System.out.println(listLoanFilter);
        listLoanFilter=limitToAttraction(listLoanFilter,attraction);
        System.out.println(listLoanFilter);
        return listLoanFilter;
    }
}
