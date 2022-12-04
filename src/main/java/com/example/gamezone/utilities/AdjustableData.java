package com.example.gamezone.utilities;

import com.example.gamezone.service.impl.Arcade;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdjustableData {
    private final Arcade arcade;
    public AdjustableData(Arcade arcade){
        this.arcade=arcade;
    }
    public void employeeAdjust(ObservableList employeeObservableList, TextField txtUsernameEmployee, TextField txtEmailEmployee, TextField txtPasswordEmployee, TableView tableEmployee) throws IOException {
        arcade.getPersistenceEmployee().saveEmployee(arcade.getEmployeeService().getListEmployee());
        employeeObservableList=arcade.getConvertToObservableList().EmployeeObservableList(arcade.getEmployeeService().getListEmployee(),employeeObservableList);
        arcade.getPreparatorTable().refreshTable(employeeObservableList,tableEmployee);
        arcade.getDeleteInfoInputs().deleteInfo3TxtField(txtUsernameEmployee,txtEmailEmployee,txtPasswordEmployee);
    }

    public void employeeDTOAdjust(ObservableList employeeDTOObservableList, TextField txtSalaryEmployee, Text txtUsernameEmployee,Text txtEmailEmployee,TableView tableEmployeeDTO) throws IOException{
        arcade.getPersistenceEmployee().saveEmployee(arcade.getEmployeeService().getListEmployee());
        employeeDTOObservableList=arcade.getConvertToObservableList().EmployeeDTObservableList(arcade.getEmployeeService().getListEmployee(),employeeDTOObservableList);
        arcade.getPreparatorTable().refreshTable(employeeDTOObservableList,tableEmployeeDTO);
        arcade.getDeleteInfoInputs().deleteText3Field(txtSalaryEmployee,txtEmailEmployee,txtUsernameEmployee);
    }

    public void attractionAdjust(ObservableList attractionObservableList, TextField txtNameAttraction, TextField txtCodeAttraction, TextField txtPriceAttraction, ComboBox cbTypeAttraction,TableView tableAttraction)throws IOException{
        arcade.getPersistenceAttraction().saveAttractions(arcade.getAttractionService().getAttractions());
        attractionObservableList=arcade.getConvertToObservableList().attractionsObservableList(arcade.getAttractionService().getAttractions(), attractionObservableList);
        arcade.getPreparatorTable().refreshTable(attractionObservableList,tableAttraction);
        arcade.getDeleteInfoInputs().deleteWithComboBox(txtCodeAttraction,txtNameAttraction,txtPriceAttraction,cbTypeAttraction);
    }

    public void loanAdjust() throws IOException {
        arcade.getPersistenceLoan().saveEmployee(arcade.getLoanService().getListLoans());
    }
}
