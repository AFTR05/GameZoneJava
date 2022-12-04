package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.LoanDTO;
import com.example.gamezone.model.*;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashSet;

public class SercherObject {

    public LoanDTO getLoanDTO(ObservableList<LoanDTO> loanDTOS, String beginHour,String endHour,String codeAttraction){
        for (LoanDTO loanDTO:loanDTOS){
            if (loanDTO.getBeginHour().equals(beginHour) && loanDTO.getEndHour().equals(endHour) && loanDTO.getCodeAttraction().equals(codeAttraction) ){
                return loanDTO;
            }
        }
        return null;
    }
    public Person getPerson(String username, String password, HashSet<? extends Person> listPeople) {
        for (Person person : listPeople) {
            if(person.getPassword().equals(password) && person.getName().equals(username)){return person;}
        }
        return null;
    }

    public Client getClient(String username, String password, HashSet<Client> listPeople) {
        for (Client client : listPeople) {
            if(client.getPassword().equals(password) && client.getName().equals(username)){return client;}
        }
        return null;
    }

    public Employee getEmployee(String username, String email, HashSet<Employee> listEmployee){
        for(Employee employee:listEmployee){
            if (employee.getEmail().equals(email) && employee.getName().equals(username)){
                return employee;
            }
        }
        return null;
    }

    public Attraction getAttraction(String code, HashSet<Attraction> listAttraction){
        for (Attraction attraction:listAttraction){
            if (attraction.getCode().equals(code)){
                return attraction;
            }
        }
        return null;
    }

}
