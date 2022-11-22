package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AjustableData {
    public void employeeAjust(ModelFactoryController mfc, ObservableList employeeObservableList, TextField txtUsernameEmployee, TextField txtEmailEmployee, TextField txtPasswordEmployee, TableView tableEmployee) throws IOException {
        mfc.getArcade().getPersistenceEmployee().saveEmployee(mfc.getArcade().getEmployeeService().getListEmployee());
        employeeObservableList=mfc.getArcade().getConvertToObservableList().EmployeeObservableList(mfc.getArcade().getEmployeeService().getListEmployee(),employeeObservableList);
        mfc.getArcade().getPreparatorTable().refreshTable(employeeObservableList,tableEmployee);
        mfc.getArcade().getDeleteInfoInputs().deleteInfo3TxtField(txtUsernameEmployee,txtEmailEmployee,txtPasswordEmployee);
    }
}
