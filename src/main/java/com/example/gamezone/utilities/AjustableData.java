package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.service.impl.Arcade;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AjustableData {
    private final Arcade arcade;
    public AjustableData(Arcade arcade){
        this.arcade=arcade;
    }
    public void employeeAjust(ObservableList employeeObservableList, TextField txtUsernameEmployee, TextField txtEmailEmployee, TextField txtPasswordEmployee, TableView tableEmployee) throws IOException {
        arcade.getPersistenceEmployee().saveEmployee(arcade.getEmployeeService().getListEmployee());
        employeeObservableList=arcade.getConvertToObservableList().EmployeeObservableList(arcade.getEmployeeService().getListEmployee(),employeeObservableList);
        arcade.getPreparatorTable().refreshTable(employeeObservableList,tableEmployee);
        arcade.getDeleteInfoInputs().deleteInfo3TxtField(txtUsernameEmployee,txtEmailEmployee,txtPasswordEmployee);
    }
}
