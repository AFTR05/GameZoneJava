package com.example.gamezone.utilities;

import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Person;

import java.util.HashSet;

public class SercherObject {

    public Person getPerson(String username, String password, HashSet<? extends Person> listPeople) {
        for (Person person : listPeople) {
            if(person.getPassword().equals(password) && person.getName().equals(username)){return person;}
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
