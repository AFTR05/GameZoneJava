package com.example.gamezone.service.impl;

import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Person;
import com.example.gamezone.service.PersonService;

import java.util.HashSet;
import java.util.Set;

public class EmployeeServiceImpl implements PersonService {
    private HashSet<Employee> listEmployee;

    public HashSet<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(HashSet<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
}
