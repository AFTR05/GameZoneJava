package com.example.gamezone.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.util.converter.LocalDateStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AdminLoanViewController implements Initializable {
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datePickerLoanAdmin.setConverter(new LocalDateStringConverter(formatter,null));
        mfc.getArcade().getDinamicCreator().putOnDataAttractionEmp(mfc.getArcade().getAttractionService().getAttractions(), vBoxPrincipal,datePickerLoanAdmin,mfc);
    }

    @FXML
    private DatePicker datePickerLoanAdmin;

    @FXML
    private VBox vBoxPrincipal;

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
    void changeToLoans(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminLoanView.fxml");
    }

    @FXML
    void changeToProfile(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminProfileView.fxml");
    }

}
