package com.example.gamezone.controller;


import com.example.gamezone.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeProfileViewController implements Initializable {
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    private Employee meEmployee;

    public Employee getMeEmployee() {
        return meEmployee;
    }

    public void setMeEmployee(Employee meEmployee) {
        this.meEmployee = meEmployee;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        meEmployee=mfc.getArcade().getEmployeeViewController().getMeEmployee();
        mfc.getArcade().getShowInputs().showInProfile(txtUsernameEmployeeProfile,txtEmailEmployeeProfile,txtPasswordEmployeeProfile,meEmployee);
    }

    @FXML
    private Button btnLoansEmployeeProfile;

    @FXML
    private Button btnLogooutEmployeeProfile;

    @FXML
    private Button btnSaveEmployeeProfile;

    @FXML
    private TextField txtEmailEmployeeProfile;

    @FXML
    private TextField txtPasswordEmployeeProfile;

    @FXML
    private TextField txtUsernameEmployeeProfile;

    @FXML
    void Logout(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Login/loginView.fxml");
    }

    @FXML
    void Save(ActionEvent event) throws IOException{
        if (mfc.getArcade().getCloneValidator().verifyClone(txtUsernameEmployeeProfile.getText(),meEmployee) && mfc.getArcade().getEmptyValidator().validateEmpty3Space(txtUsernameEmployeeProfile.getText(),txtEmailEmployeeProfile.getText(),txtPasswordEmployeeProfile.getText())&&mfc.getArcade().getEmailValidator().verifyEmail(txtEmailEmployeeProfile.getText())) {
            mfc.getArcade().getUpdaterObject().personUpdate(mfc.getArcade().getSercherObject().getPerson(meEmployee.getName(),meEmployee.getPassword(),mfc.getArcade().getEmployeeService().getListEmployee()),txtUsernameEmployeeProfile.getText(),txtEmailEmployeeProfile.getText(),txtPasswordEmployeeProfile.getText());
            mfc.getArcade().getPersistenceEmployee().saveEmployee(mfc.getArcade().getEmployeeService().getListEmployee());
            mfc.getArcade().getAlertGenerator().alertInformation("Successful update",null);
            mfc.getArcade().getEmployeeViewController().setMeEmployee((Employee) mfc.getArcade().getSercherObject().getPerson(txtUsernameEmployeeProfile.getText(),txtPasswordEmployeeProfile.getText(),mfc.getArcade().getEmployeeService().getListEmployee()));
            mfc.getArcade().getChangerFXML().sceneChange(event,"view/Employee/EmployeeProfileView.fxml");
        }
    }

    @FXML
    void changeToLoans(ActionEvent event) {

    }

}
