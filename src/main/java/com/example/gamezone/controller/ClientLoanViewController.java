package com.example.gamezone.controller;

import com.example.gamezone.DTOs.LoanDTO;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.LocalDateStringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

public class ClientLoanViewController implements Initializable {
    private ModelFactoryController mfc =ModelFactoryController.getInstance();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LoanDTO loanDTOSelected;
    private Attraction attractionSelected;
    private Client meClient;

    public Attraction getAttractionSelected() {
        return attractionSelected;
    }

    public void setAttractionSelected(Attraction attractionSelected) {
        this.attractionSelected = attractionSelected;
    }

    public Client getMeClient() {
        return meClient;
    }

    public void setMeClient(Client meClient) {
        this.meClient = meClient;
    }

    public LoanDTO getLoanDTOSelected() {
        return loanDTOSelected;
    }

    public void setLoanDTOSelected(LoanDTO loanDTOSelected) {
        this.loanDTOSelected = loanDTOSelected;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        datePickerLoanClient.setConverter(new LocalDateStringConverter(formatter,null));
        mfc.getArcade().getDinamicCreator().putOnDataAttraction(mfc.getArcade().getAttractionService().getAttractions(), vBoxPrincipal,datePickerLoanClient,mfc);

    }


    @FXML
    private DatePicker datePickerLoanClient;
    @FXML
    private VBox vBoxPrincipal;

    @FXML
    void changeToLoan(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientLoanView.fxml");

    }

    @FXML
    void changeToProfile(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientProfileView.fxml");

    }

    @FXML
    void confirmLoan(ActionEvent event) throws IOException {
        attractionSelected=mfc.getArcade().getClientLoanViewController().getAttractionSelected();
        meClient=mfc.getArcade().getClientLoanViewController().getMeClient();
        loanDTOSelected=mfc.getArcade().getClientLoanViewController().getLoanDTOSelected();
        if ((mfc.getArcade().getSelectValidator().validateLoanDTO(loanDTOSelected) && mfc.getArcade().getSelectValidator().validateAttraction(attractionSelected) && mfc.getArcade().getSelectValidator().validatePerson(meClient) && mfc.getArcade().getTimeValidator().validateDatePicker(datePickerLoanClient))){
            mfc.createLoan(LocalDateTime.parse(datePickerLoanClient.getValue().toString()+"T"+loanDTOSelected.getBeginHour()),LocalDateTime.parse(datePickerLoanClient.getValue().toString()+"T"+loanDTOSelected.getEndHour()),meClient,attractionSelected);
            mfc.getArcade().getUpdaterObject().clientUpdate(mfc.getArcade().getSercherObject().getClient(meClient.getName(), meClient.getPassword(), mfc.getArcade().getClientService().getListClients()));
             CompletableFuture.runAsync(()-> {
                 try {
                     mfc.getArcade().getAjustableData().loanAdjust();
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             });
             CompletableFuture.runAsync(()-> {
                 try {
                     mfc.getArcade().getPersistenceClient().saveClients(mfc.getArcade().getClientService().getListClients());
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             });
            mfc.getArcade().getChangerFXML().sceneChange(event,"view/Client/ClientLoanView.fxml");
        }
    }

}
