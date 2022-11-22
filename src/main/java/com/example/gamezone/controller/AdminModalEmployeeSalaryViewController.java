package com.example.gamezone.controller;

import com.example.gamezone.DTOs.EmployeeDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    private ObservableList<EmployeeDTO> employeeObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    }

    @FXML
    void changeSalary(ActionEvent event) {

    }

}
