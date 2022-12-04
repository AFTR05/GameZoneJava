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

public class ClientProfileViewController implements Initializable {
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    private Client meClient;

    public Client getMeClient() {
        return meClient;
    }

    public void setMeClient(Client meClient) {
        this.meClient = meClient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        meClient=mfc.getArcade().getClientViewController().getMeClient();
        mfc.getArcade().getShowInputs().showInProfile(txtUsernameClientProfile,txtEmailClientProfile,txtPasswordClientProfile,meClient);
    }

    @FXML
    private Button btnLoansClientProfile;

    @FXML
    private Button btnLogoutProfileView;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtEmailClientProfile;

    @FXML
    private TextField txtPasswordClientProfile;

    @FXML
    private TextField txtUsernameClientProfile;

    @FXML
    void Logout(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Login/loginView.fxml");
    }

    @FXML
    void Save(ActionEvent event) throws IOException{
        if (mfc.getArcade().getCloneValidator().verifyClone(txtUsernameClientProfile.getText(),meClient) && mfc.getArcade().getEmptyValidator().validateEmpty3Space(txtUsernameClientProfile.getText(),txtEmailClientProfile.getText(),txtPasswordClientProfile.getText())&&mfc.getArcade().getEmailValidator().verifyEmail(txtEmailClientProfile.getText())) {
            mfc.getArcade().getUpdaterObject().personUpdate(mfc.getArcade().getSercherObject().getPerson(meClient.getName(), meClient.getPassword(), mfc.getArcade().getClientService().getListClients()),txtUsernameClientProfile.getText(),txtEmailClientProfile.getText(),txtPasswordClientProfile.getText());
            mfc.getArcade().getPersistenceClient().saveClients(mfc.getArcade().getClientService().getListClients());
            mfc.getArcade().getAlertGenerator().alertInformation("Successful update",null);
            mfc.getArcade().getClientViewController().setMeClient((Client) mfc.getArcade().getSercherObject().getPerson(txtUsernameClientProfile.getText(),txtPasswordClientProfile.getText(),mfc.getArcade().getClientService().getListClients()));
            mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientProfileView.fxml");
        }
    }

    @FXML
    void changeToLoans(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientLoanView.fxml");

    }

    @FXML
    void changeToProfile(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientProfileView.fxml");

    }
}
