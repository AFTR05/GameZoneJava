package com.example.gamezone.controller;

import com.example.gamezone.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminEmployeeViewController implements Initializable {
    private ModelFactoryController mfc=ModelFactoryController.getInstance();
    private ObservableList<Employee> employeeObservableList=FXCollections.observableArrayList();
    private Employee employeeSelected;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeObservableList=mfc.getArcade().getConvertToObservableList().EmployeeObservableList(mfc.getArcade().getEmployeeService().getListEmployee(),employeeObservableList);
        mfc.getArcade().getPreparatorTable().prepareTablePerson(columnUsernameEmployeeAdmin,columnEmailEmployeeAdmin,columnPasswordEmployeeAdmin);
        tableEmployeeAdmin.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            employeeSelected =newSelection;
            mfc.getArcade().getShowInputs().showEmployeeInformation(employeeSelected,txtUsernameEmployeeAdmin,txtEmailEmployeeAdmin,txtPasswordEmployeeAdmin);
        });
        tableEmployeeAdmin.setItems(employeeObservableList);
    }

    @FXML
    private Button btnAttractionsAdminEmployee;

    @FXML
    private Button btnCancelSelectionEmployeeAdmin;

    @FXML
    private Button btnClientAdminEmployee;

    @FXML
    private Button btnCreateEmployeeAdmin;

    @FXML
    private Button btnDeleteEmployeeAdmin;

    @FXML
    private Button btnEmployeeAdminEmployee;

    @FXML
    private Button btnLoanAdminEmployee;

    @FXML
    private Button btnProfileAdminEmployee;

    @FXML
    private Button btnUpdateSalaryEmployeeAdmin;

    @FXML
    private TableColumn<Employee, String> columnEmailEmployeeAdmin;

    @FXML
    private TableColumn<Employee, String> columnPasswordEmployeeAdmin;

    @FXML
    private TableColumn<Employee, String> columnUsernameEmployeeAdmin;

    @FXML
    private TableView<Employee> tableEmployeeAdmin;

    @FXML
    private TextField txtEmailEmployeeAdmin;

    @FXML
    private TextField txtPasswordEmployeeAdmin;

    @FXML
    private TextField txtUsernameEmployeeAdmin;

    @FXML
    void ToUpdateModal(ActionEvent event) throws IOException{
        mfc.getArcade().getAdminModalEmployeeSalaryViewController().setMfc(mfc);
        mfc.getArcade().getChangerFXML().modalChange("view/Admin/AdminModalEmployeeSalaryView.fxml");
    }

    @FXML
    void cancelSelection(ActionEvent event) {
        employeeSelected=null;
        mfc.getArcade().getDeleteInfoInputs().deleteInfo3TxtField(txtUsernameEmployeeAdmin,txtEmailEmployeeAdmin,txtPasswordEmployeeAdmin);
    }
    @FXML
    void createEmployee(ActionEvent event) throws IOException{
        if (mfc.getArcade().getCloneValidator().verifySign(mfc,txtUsernameEmployeeAdmin.getText())&& mfc.getArcade().getEmptyValidator().validateEmpty3Space(mfc,txtUsernameEmployeeAdmin.getText(),txtEmailEmployeeAdmin.getText(),txtPasswordEmployeeAdmin.getText()) && mfc.getArcade().getEmailValidator().verifyEmail(txtEmailEmployeeAdmin.getText(),mfc)){
            mfc.createEmployee(txtUsernameEmployeeAdmin.getText(),txtEmailEmployeeAdmin.getText(),txtPasswordEmployeeAdmin.getText());
            mfc.getArcade().getAjustableData().employeeAjust(mfc,employeeObservableList,txtUsernameEmployeeAdmin,txtEmailEmployeeAdmin,txtPasswordEmployeeAdmin,tableEmployeeAdmin);
        }

    }

    @FXML
    void deleteEmployee(ActionEvent event) throws IOException{
        if (mfc.getArcade().getSelectValidator().validatePerson(employeeSelected,mfc)){
            mfc.deleteEmployee(txtUsernameEmployeeAdmin.getText(),txtPasswordEmployeeAdmin.getText(),mfc);
            mfc.getArcade().getAjustableData().employeeAjust(mfc,employeeObservableList,txtUsernameEmployeeAdmin,txtEmailEmployeeAdmin,txtPasswordEmployeeAdmin,tableEmployeeAdmin);
        }

    }

    @FXML
    void changeToClients(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminClientView.fxml");

    }

    @FXML
    void changeToEmployees(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminEmployeeView.fxml");

    }
    @FXML
    void changeToProfile(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminProfileView.fxml");

    }
    @FXML
    void changeToAttractions(ActionEvent event) {

    }




    @FXML
    void changeToLoans(ActionEvent event) {

    }


}
