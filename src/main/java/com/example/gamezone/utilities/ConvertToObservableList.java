package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.DTOs.EmployeeDTO;
import com.example.gamezone.controller.ModelFactoryController;
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

    public ObservableList<Employee> EmployeeObservableList(HashSet<Employee> listPeople,ObservableList<Employee> observableListPeople){
        observableListPeople= FXCollections.observableArrayList(listPeople);
        return observableListPeople;
    }

    public ObservableList<EmployeeDTO> EmployeeDTObservableList(HashSet<Employee> listEmployee,ObservableList<EmployeeDTO> observableListEmployee){
        for (Employee employee:listEmployee){
            observableListEmployee.add(new EmployeeDTO(employee.getName(), employee.getEmail(), employee.getTotalIncome()));
        }
        return observableListEmployee;
    }
}
