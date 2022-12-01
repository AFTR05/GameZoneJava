package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.DTOs.EmployeeDTO;
import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashSet;

public class ConvertToObservableList {
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
