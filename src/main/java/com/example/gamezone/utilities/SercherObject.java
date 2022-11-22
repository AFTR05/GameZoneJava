package com.example.gamezone.utilities;

import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Person;

import java.util.HashSet;

public class SercherObject {

    public Person getPerson(String username, String password, HashSet<? extends Person> listClients) {
        for (Person person : listClients) {
            if(person.getPassword().equals(password) && person.getName().equals(username)){return person;}
        }
        return null;
    }

}
