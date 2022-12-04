package com.example.gamezone.utilities;

import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Person;
import javafx.scene.control.TextField;

public class UpdaterObject {
    public void personUpdate(Person person, String name, String email,String password){
        person.setName(name);
        person.setEmail(email);
        person.setPassword(password);
    }

    public void clientUpdate(Client client){
        client.setAmountLoan(client.getAmountLoan()+1);
    }

    public void employeeUpdate(Employee employee,String name,String email, Double salary){
        employee.setEmail(email);
        employee.setName(name);
        employee.setTotalIncome(salary);
    }
}
