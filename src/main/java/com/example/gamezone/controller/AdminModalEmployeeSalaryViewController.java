package com.example.gamezone.controller;

import com.example.gamezone.DTOs.EmployeeDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminModalEmployeeSalaryViewController implements Initializable {

    private ModelFactoryController mfc=ModelFactoryController.getInstance();

    public ModelFactoryController getMfc() {
        return mfc;
    }

    public void setMfc(ModelFactoryController mfc) {
        this.mfc = mfc;
    }

    private EmployeeDTO employeeDTOSelected;
    private ObservableList<EmployeeDTO> employeeObservableList= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData();
        mfc.getArcade().getConvertToObservableList().EmployeeDTObservableList(mfc.getArcade().getEmployeeService().getListEmployee(),employeeObservableList);
        mfc.getArcade().getChargerData().chargeData();
        mfc.getArcade().getPreparatorTable().prepareTableEmployeeDTO(columnUsernameModalEmployeeSalary,columnEmailModalEmployeeSalary,columnSalaryModalEmployeeSalary);
        tableModelEmployeeSalary.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            employeeDTOSelected =newSelection;
            mfc.getArcade().getShowInputs().showEmployeeDTO(employeeDTOSelected,txtUsernameModalEmployee,txtEmailModalEmployee,txtSalaryModalEmployee);
        });
        tableModelEmployeeSalary.setItems(employeeObservableList);
    }

    @FXML
    private Button btnCancelSalaryEmployeeModal;

    @FXML
    private Button btnUpdateSalaryEmployeeModal;

    @FXML
    private TableColumn<EmployeeDTO, String> columnEmailModalEmployeeSalary;

    @FXML
    private TableColumn<EmployeeDTO, Double> columnSalaryModalEmployeeSalary;

    @FXML
    private TableColumn<EmployeeDTO, String> columnUsernameModalEmployeeSalary;

    @FXML
    private TableView<EmployeeDTO> tableModelEmployeeSalary;

    @FXML
    private Text txtEmailModalEmployee;

    @FXML
    private TextField txtSalaryModalEmployee;

    @FXML
    private Text txtUsernameModalEmployee;

    @FXML
    void cancel(ActionEvent event) {
        employeeDTOSelected=null;
        mfc.getArcade().getDeleteInfoInputs().deleteText3Field(txtSalaryModalEmployee,txtUsernameModalEmployee,txtEmailModalEmployee);
    }

    @FXML
    void changeSalary(ActionEvent event) throws IOException {
        if (mfc.getArcade().getSelectValidator().validateEmployeeDTO(employeeDTOSelected) && mfc.getArcade().getSalaryValidation().numberValidation(txtSalaryModalEmployee.getText())){
            mfc.getArcade().getUpdaterObject().employeeUpdate(mfc.getArcade().getSercherObject().getEmployee(txtUsernameModalEmployee.getText(),txtEmailModalEmployee.getText(),mfc.getArcade().getEmployeeService().getListEmployee()),txtUsernameModalEmployee.getText(),txtEmailModalEmployee.getText(),Double.parseDouble(txtSalaryModalEmployee.getText()));
            mfc.getArcade().getAjustableData().employeeDTOAdjust(employeeObservableList,txtSalaryModalEmployee,txtUsernameModalEmployee,txtEmailModalEmployee,tableModelEmployeeSalary);
        }
    }

}
