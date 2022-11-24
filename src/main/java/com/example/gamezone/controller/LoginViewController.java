package com.example.gamezone.controller;

import com.example.gamezone.model.Administrator;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
import com.example.gamezone.threads.AdminDataThread;
import com.example.gamezone.threads.ClientDataThread;
import com.example.gamezone.threads.EmployeeDataThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
    }

    private ModelFactoryController mfc=ModelFactoryController.getInstance();
    @FXML
    private Button LoginBtn;

    @FXML
    private Button SignUpBtn;

    @FXML
    private AnchorPane loginScreen;

    @FXML
    private TextField passwordLoginTxt;

    @FXML
    private TextField usernameLoginTxt;

    @FXML
    void Login(ActionEvent event) throws IOException{
        if(!mfc.getArcade().getLoginAction().adminLogin(usernameLoginTxt.getText(),passwordLoginTxt.getText())){
            switch (mfc.getArcade().getLoginAction().DefaultLogin(usernameLoginTxt.getText(),passwordLoginTxt.getText())){
                case "client":
                    new ClientDataThread().start();
                    mfc.getArcade().getClientViewController().setMeClient((Client) mfc.getArcade().getSercherObject().getPerson(usernameLoginTxt.getText(),passwordLoginTxt.getText(),mfc.getArcade().getClientService().getListClients()));
                    mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientProfileView.fxml");
                    break;
                case "employee":
                    new EmployeeDataThread().run();
                    mfc.getArcade().getEmployeeViewController().setMeEmployee((Employee) mfc.getArcade().getSercherObject().getPerson(usernameLoginTxt.getText(),passwordLoginTxt.getText(),mfc.getArcade().getEmployeeService().getListEmployee()));
                    mfc.getArcade().getChangerFXML().sceneChange(event,"view/Employee/EmployeeProfileView.fxml");
                    break;
                case "":

                    mfc.getArcade().getAlertGenerator().alertError("The person does not exits",null);
                    break;
            }
        }else {
            new AdminDataThread().run();
            mfc.getArcade().getAdminViewController().setMeAdmin(mfc.getArcade().getAdministratorService().getAdministrator());
            mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminProfileView.fxml");
        }
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Login/signUpView.fxml");
    }

}
