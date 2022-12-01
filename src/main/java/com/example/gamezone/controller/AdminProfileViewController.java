package com.example.gamezone.controller;
import com.example.gamezone.model.Administrator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminProfileViewController implements Initializable {
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    private Administrator meAdmin;

    public Administrator getMeAdmin() {
        return meAdmin;
    }

    public void setMeAdmin(Administrator meAdmin) {
        this.meAdmin = meAdmin;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        meAdmin=mfc.getArcade().getAdminViewController().getMeAdmin();
        mfc.getArcade().getShowInputs().showInProfile(txtUsernameAdminProfile,txtEmailAdminProfile,txtPasswordAdminProfile,meAdmin);
    }

    @FXML
    private Button btnClientsAdminProfile;

    @FXML
    private Button btnEmployeesAdminProfile;

    @FXML
    private Button btnLoansAdminProfile;

    @FXML
    private Button btnLogoutAdminProfile;

    @FXML
    private Button btnSaveAdminProfile;
    @FXML
    private Button btnAttractionsAdminProfile;
    @FXML
    private TextField txtEmailAdminProfile;

    @FXML
    private TextField txtPasswordAdminProfile;

    @FXML
    private TextField txtUsernameAdminProfile;

    @FXML
    void Logout(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Login/loginView.fxml");
    }

    @FXML
    void Save(ActionEvent event) throws IOException{
        if (mfc.getArcade().getCloneValidator().verifyClone(txtUsernameAdminProfile.getText(),meAdmin) && mfc.getArcade().getEmptyValidator().validateEmpty3Space(txtUsernameAdminProfile.getText(),txtEmailAdminProfile.getText(),txtPasswordAdminProfile.getText())&&mfc.getArcade().getEmailValidator().verifyEmail(txtEmailAdminProfile.getText())){
            mfc.getArcade().getUpdaterObject().personUpdate(mfc.getArcade().getAdministratorService().getAdministrator(),txtUsernameAdminProfile.getText(),txtEmailAdminProfile.getText(),txtPasswordAdminProfile.getText());
            mfc.getArcade().getPersistenceAdmin().saveAdministrator(mfc.getArcade().getAdministratorService().getAdministrator());
            mfc.getArcade().getAlertGenerator().alertInformation("Successful update",null);
            mfc.getArcade().getAdminViewController().setMeAdmin(mfc.getArcade().getAdministratorService().getAdministrator());
            mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminProfileView.fxml");
        }

    }

    @FXML
    void changeToAttractions(ActionEvent event)throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminAttractionView.fxml");
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
    void changeToLoans(ActionEvent event) {

    }

    @FXML
    void changeToProfile(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminProfileView.fxml");

    }
}
