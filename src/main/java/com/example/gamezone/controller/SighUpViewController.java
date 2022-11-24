package com.example.gamezone.controller;

import com.example.gamezone.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SighUpViewController implements Initializable {
    private ModelFactoryController mfc=ModelFactoryController.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
    }

    @FXML
    private TextField AgeSignTxt;

    @FXML
    private TextField EmailSighTxt;

    @FXML
    private TextField PasswordSighTxt;

    @FXML
    private Button RegisterSighButton;

    @FXML
    private Button backSignBtn;

    @FXML
    private TextField nameSignTxt;

    @FXML
    void RegisterClient(ActionEvent event) throws IOException{
        if(mfc.getArcade().getCloneValidator().verifySign(nameSignTxt.getText())&& mfc.getArcade().getEmptyValidator().validateEmpty3Space(nameSignTxt.getText(),EmailSighTxt.getText(),PasswordSighTxt.getText()) && mfc.getArcade().getEmailValidator().verifyEmail(EmailSighTxt.getText())){
            mfc.createClient(nameSignTxt.getText(), EmailSighTxt.getText(),PasswordSighTxt.getText());
            mfc.getArcade().getPersistenceClient().saveClients(mfc.getArcade().getClientService().getListClients());
            mfc.getArcade().getAlertGenerator().alertInformation("you can login now","The client was created successfully");
            mfc.getArcade().getChangerFXML().sceneChange(event,"view/Login/loginView.fxml");
        }
    }

    @FXML
    void backLogin(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Login/loginView.fxml");
    }

}
