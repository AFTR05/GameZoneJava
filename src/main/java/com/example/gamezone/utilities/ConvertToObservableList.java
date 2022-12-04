package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.DTOs.EmployeeDTO;
import com.example.gamezone.DTOs.LoanDTO;
import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.*;
import com.example.gamezone.service.impl.Arcade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class ConvertToObservableList {
    private Arcade arcade;

    public ConvertToObservableList(Arcade arcade) {
        this.arcade = arcade;
    }

    public ObservableList<LoanDTO> loanDTOObservable(Attraction attraction, ObservableList<LoanDTO> loanDTOS , LocalDate date){
        loanDTOS.clear();
        for (int x=7;x<=20;x++){
            if (Integer.parseInt(arcade.getTimeConverter().localDateTimeToHour(LocalDateTime.now()).split(":")[0])>x && date.isEqual(LocalDate.now())){
                continue;
            }
            if (x>9){
                loanDTOS.add(new LoanDTO(x+":00",(x+1)+":00",attraction.getName(),attraction.getCode()));
            }else if (x==9) {
                loanDTOS.add(new LoanDTO("0"+x+":00",(x+1)+":00",attraction.getName(),attraction.getCode()));
            }else {
                loanDTOS.add(new LoanDTO("0"+x+":00","0"+(x+1)+":00",attraction.getName(),attraction.getCode()));
            }

        }
        return loanDTOS;
    }

    public ObservableList<LoanDTO> loanDTOLoanObservable(Attraction attraction, ObservableList<LoanDTO> loanDTOS , LocalDate date,ArrayList<Loan> listLoan){
        ArrayList<Loan> filterLoans=arcade.getFilterTimeLister().limitAll(listLoan,attraction,date.toString());
        if (filterLoans!=null){
            for (Loan loan:filterLoans){
                loanDTOS.remove(arcade.getSercherObject().getLoanDTO(loanDTOS,arcade.getTimeConverter().localDateTimeToHour(loan.getBeginDate()),arcade.getTimeConverter().localDateTimeToHour(loan.getEndDate()),loan.getAttraction().getCode()));
            }
        }
        return loanDTOS;
    }

    public ObservableList<ClientDTO> clientDTObservable(HashSet<Client> listclient,ObservableList<ClientDTO> observableListClient){
        for (Client client : listclient) {
            observableListClient.add(new ClientDTO(client.getName(),client.getAmountLoan(),client.getEmail()));
        }
        return observableListClient;
    }

    public ObservableList<AttractionDTO> attractionsObservableList(HashSet<Attraction> listAttraction, ObservableList<AttractionDTO> attractionsObservable){
        attractionsObservable.clear();
        for (Attraction attraction:listAttraction){
            attractionsObservable.add(new AttractionDTO(attraction.getName(),attraction.getCode(),attraction.getTypeAttraction().getCategory(),attraction.getPrice()));
        }
        return attractionsObservable;
    }
    public ObservableList<Employee> EmployeeObservableList(HashSet<Employee> listPeople,ObservableList<Employee> observableListPeople){
        observableListPeople= FXCollections.observableArrayList(listPeople);
        return observableListPeople;
    }

    public ObservableList<EmployeeDTO> EmployeeDTObservableList(HashSet<Employee> listEmployee,ObservableList<EmployeeDTO> observableListEmployee){
        observableListEmployee.clear();
        for (Employee employee:listEmployee){
            observableListEmployee.add(new EmployeeDTO(employee.getName(), employee.getEmail(), employee.getTotalIncome()));
        }
        return observableListEmployee;
    }
}
