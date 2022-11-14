package com.example.gamezone.persistence;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class PersistenceEmployee {
    public static final String RUTE_ARCHIVE_EMPLOYEE = "src/main/java/com/example/gamezone/Data/employees.txt";

    public void saveEmployee(HashSet<Employee> listEmployee) throws IOException {
        String contenido = "";
        for(Employee employee: listEmployee) {
            contenido+= employee.getName()+"/"+employee.getEmail()+"/"+employee.getPassword()+"\n";
        }
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_EMPLOYEE, contenido, false);
    }

    public HashSet<Employee> chargeEmployee() throws FileNotFoundException, IOException {
        HashSet<Employee> employees = new HashSet<Employee>();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_EMPLOYEE);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            Employee myEmployee = new Employee();
            line= content.get(i);
            myEmployee.setName(line.split("/")[0]);
            myEmployee.setEmail(line.split("/")[1]);
            myEmployee.setPassword(line.split("/")[2]);
            employees.add(myEmployee);
        }
        return employees;
    }

}
