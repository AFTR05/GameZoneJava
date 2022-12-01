package com.example.gamezone.controller;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminClientViewController implements Initializable {
    private ModelFactoryController mfc=ModelFactoryController.getInstance();
    private ObservableList<ClientDTO> observableClients= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        observableClients=mfc.getArcade().getConvertToObservableList().clientDTObservable(mfc.getArcade().getClientService().getListClients(),observableClients);
        mfc.getArcade().getPreparatorTable().prepareTableClient(columnUsernameClientAdmin,columnEmailClientAdmin,columnAmountClientAdmin);
        tableClientAdmin.setItems(observableClients);
    }

    @FXML
    private Button btnAttractionsAdminClient;

    @FXML
    private Button btnClientAdminClient;

    @FXML
    private Button btnEmployeeAdminClient;

    @FXML
    private Button btnLoanAdminClient;

    @FXML
    private Button btnProfileAdminClient;

    @FXML
    private TableColumn<ClientDTO, Integer> columnAmountClientAdmin;

    @FXML
    private TableColumn<ClientDTO, String> columnEmailClientAdmin;

    @FXML
    private TableColumn<ClientDTO, String> columnUsernameClientAdmin;

    @FXML
    private TableView<ClientDTO> tableClientAdmin;


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
