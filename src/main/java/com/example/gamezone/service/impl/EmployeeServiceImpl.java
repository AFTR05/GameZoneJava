package com.example.gamezone.service.impl;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Employee;
import com.example.gamezone.service.PersonService;

import java.util.HashSet;

public class EmployeeServiceImpl implements PersonService {
    private HashSet<Employee> listEmployee;
    private final Arcade arcade;

    public EmployeeServiceImpl(Arcade arcade) {
        this.arcade = arcade;
    }

    public HashSet<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(HashSet<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    @Override
    public void createPerson(String name, String email, String password) {
        listEmployee.add(new Employee(name,password,email));
    }

    @Override
    public void deletePerson(String name, String password) {
        Employee employee=(Employee) arcade.getSercherObject().getPerson(name,password,listEmployee);
        if (arcade.getSelectValidator().validatePerson(employee)){
            listEmployee.remove(employee);
        }
    }
}
