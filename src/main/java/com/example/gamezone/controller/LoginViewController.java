package com.example.gamezone.controller;

import com.almasb.fxgl.core.concurrent.Async;
import com.example.gamezone.model.Administrator;
import com.example.gamezone.model.Client;
import com.example.gamezone.model.Employee;
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
import java.util.concurrent.CompletableFuture;

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
                    CompletableFuture.runAsync(()->mfc.getArcade().getClientViewController().setMeClient((Client) mfc.getArcade().getSercherObject().getPerson(usernameLoginTxt.getText(),passwordLoginTxt.getText(),mfc.getArcade().getClientService().getListClients())));
                    CompletableFuture.runAsync(()->mfc.getArcade().getClientLoanModalViewController().setMeClient((Client) mfc.getArcade().getSercherObject().getPerson(usernameLoginTxt.getText(),passwordLoginTxt.getText(),mfc.getArcade().getClientService().getListClients())));
                    CompletableFuture.runAsync(()->mfc.getArcade().getClientLoanViewController().setMeClient((Client) mfc.getArcade().getSercherObject().getPerson(usernameLoginTxt.getText(),passwordLoginTxt.getText(),mfc.getArcade().getClientService().getListClients())));
                    mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientProfileView.fxml");
                    break;
                case "employee":
                    CompletableFuture.runAsync(()->mfc.getArcade().getEmployeeViewController().setMeEmployee((Employee) mfc.getArcade().getSercherObject().getPerson(usernameLoginTxt.getText(),passwordLoginTxt.getText(),mfc.getArcade().getEmployeeService().getListEmployee())));
                    mfc.getArcade().getChangerFXML().sceneChange(event,"view/Employee/EmployeeProfileView.fxml");
                    break;
                case "":
                    mfc.getArcade().getAlertGenerator().alertError("The person does not exits",null);
                    break;
            }
        }else {
            CompletableFuture.runAsync(()->mfc.getArcade().getAdminViewController().setMeAdmin(mfc.getArcade().getAdministratorService().getAdministrator()));
            mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminProfileView.fxml");
        }
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Login/signUpView.fxml");
    }

}
