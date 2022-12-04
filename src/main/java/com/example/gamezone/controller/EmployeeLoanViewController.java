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

public class EmployeeLoanViewController implements Initializable {
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        datePickerLoanEmployee.setConverter(new LocalDateStringConverter(formatter,null));
        mfc.getArcade().getDinamicCreator().putOnDataAttractionEmp(mfc.getArcade().getAttractionService().getAttractions(), vBoxPrincipal,datePickerLoanEmployee,mfc);

    }

    @FXML
    private DatePicker datePickerLoanEmployee;

    @FXML
    private VBox vBoxPrincipal;

    @FXML
    void changeToLoans(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Employee/EmployeeLoanView.fxml");
    }

    @FXML
    void changeToProfile(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Employee/EmployeeProfileView.fxml");
    }

}
