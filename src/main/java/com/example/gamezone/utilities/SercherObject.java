package com.example.gamezone.utilities;

import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Person;

import java.util.HashSet;

public class SercherObject {
    public Client getClient(String username,String password, HashSet<Client> listClients) {
        for (Client client : listClients) {
            if(client.getPassword().equals(password) && client.getName().equals(username)){return client;}
        }
        return null;
    }

    public Person getPerson(String username, String password, HashSet<? extends Person> listClients) {
        for (Person person : listClients) {
            if(person.getPassword().equals(password) && person.getName().equals(username)){return person;}
        }
        return null;
    }

    public Employee getEmployee(String username,String password, HashSet<Employee> listEmployee){
        for (Employee employee : listEmployee) {
            if(employee.getPassword().equals(password) && employee.getName().equals(username)){return employee;}
        }
        return null;
    }
}
