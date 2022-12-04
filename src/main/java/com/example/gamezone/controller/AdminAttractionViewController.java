package com.example.gamezone.controller;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.model.Attraction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminAttractionViewController implements Initializable {
    private ModelFactoryController mfc=ModelFactoryController.getInstance();
    private ObservableList<AttractionDTO> observableAttractions= FXCollections.observableArrayList();
    private AttractionDTO attractionSelected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        mfc.getArcade().getComboBoxAdder().addComboBoxOptionsTypeAttraction(cbTypeAttractionAdmin);
        observableAttractions=mfc.getArcade().getConvertToObservableList().attractionsObservableList(mfc.getArcade().getAttractionService().getAttractions(), observableAttractions);
        mfc.getArcade().getPreparatorTable().preparateTableAttraction(columnNameAttractionsAdmin,columnCodeAttractionsAdmin,columnTypeAttractionsAdmin,columnPriceAttractionsAdmin);
        tableAttractionAdmin.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            attractionSelected =newSelection;
            mfc.getArcade().getShowInputs().showAttraction(attractionSelected,txtNameAttractionAdmin,txtCodeAttractionAdmin,txtPriceAttractionAdmin,cbTypeAttractionAdmin);
        });
        tableAttractionAdmin.setItems(observableAttractions);
    }



    @FXML
    private TextField txtCodeAttractionAdmin;
    @FXML
    private Button btnCancelAttractionAdmin;

    @FXML
    private Button btnCreateAttractionAdmin;

    @FXML
    private Button btnDeleteAttractionAdmin;

    @FXML
    private Button btnUpdateAttractionAdmin;
    @FXML
    private TableColumn<AttractionDTO, String> columnTypeAttractionsAdmin;
    @FXML
    private TableColumn<AttractionDTO, String> columnCodeAttractionsAdmin;

    @FXML
    private TableColumn<AttractionDTO, String> columnNameAttractionsAdmin;

    @FXML
    private TableColumn<AttractionDTO, Double> columnPriceAttractionsAdmin;

    @FXML
    private TableView<AttractionDTO> tableAttractionAdmin;


    @FXML
    private ComboBox<String> cbTypeAttractionAdmin;

    @FXML
    private TextField txtNameAttractionAdmin;

    @FXML
    private TextField txtPriceAttractionAdmin;

    @FXML
    void cancelSelection(ActionEvent event) {
        attractionSelected=null;
        mfc.getArcade().getDeleteInfoInputs().deleteWithComboBox(txtNameAttractionAdmin,txtCodeAttractionAdmin,txtPriceAttractionAdmin,cbTypeAttractionAdmin);
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
    void changeToLoans(ActionEvent event) throws IOException {
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminLoanView.fxml");
    }

    @FXML
    void changeToProfile(ActionEvent event) throws IOException{
        mfc.getArcade().getChangerFXML().sceneChange(event,"view/Admin/AdminProfileView.fxml");
    }



    @FXML
    void createAttraction(ActionEvent event) throws IOException{
        if (mfc.getArcade().getCloneValidator().verifyCode(txtCodeAttractionAdmin.getText())&&mfc.getArcade().getEmptyValidator().validateEmpty4Space(txtNameAttractionAdmin.getText(),txtCodeAttractionAdmin.getText(),txtPriceAttractionAdmin.getText(),cbTypeAttractionAdmin.getValue())&&mfc.getArcade().getPriceValidator().validatePrice(txtPriceAttractionAdmin.getText())) {
            mfc.createAttraction(txtNameAttractionAdmin.getText(), txtCodeAttractionAdmin.getText(), Double.parseDouble(txtPriceAttractionAdmin.getText()), mfc.getArcade().getTypeConverter().stringToType(cbTypeAttractionAdmin.getValue()));
            mfc.getArcade().getAjustableData().attractionAdjust(observableAttractions, txtNameAttractionAdmin, txtCodeAttractionAdmin, txtPriceAttractionAdmin, cbTypeAttractionAdmin, tableAttractionAdmin);
        }

    }

    @FXML
    void deleteAttraction(ActionEvent event) throws IOException{
        if (mfc.getArcade().getSelectValidator().validateAttractionDTo(attractionSelected)&&mfc.getArcade().getEmptyValidator().validateDeleteAttraction(attractionSelected,txtNameAttractionAdmin.getText(),txtCodeAttractionAdmin.getText(),cbTypeAttractionAdmin.getValue(),txtPriceAttractionAdmin.getText())){
            mfc.deleteAttraction(attractionSelected.getName(), attractionSelected.getCode(), attractionSelected.getPrice(), mfc.getArcade().getTypeConverter().stringToType(attractionSelected.getCategory()));
            mfc.getArcade().getAjustableData().attractionAdjust(observableAttractions, txtNameAttractionAdmin, txtCodeAttractionAdmin, txtPriceAttractionAdmin, cbTypeAttractionAdmin, tableAttractionAdmin);
        }

    }

    @FXML
    void updateAttraction(ActionEvent event) throws IOException {
        if (mfc.getArcade().getSelectValidator().validateAttractionDTo(attractionSelected)&&mfc.getArcade().getCloneValidator().verifyCodeWithSelection(txtCodeAttractionAdmin.getText(),attractionSelected)&&mfc.getArcade().getEmptyValidator().validateEmpty4Space(txtNameAttractionAdmin.getText(),txtCodeAttractionAdmin.getText(),txtPriceAttractionAdmin.getText(),cbTypeAttractionAdmin.getValue())&&mfc.getArcade().getPriceValidator().validatePrice(txtPriceAttractionAdmin.getText())){
            mfc.updateAttraction(txtNameAttractionAdmin.getText(),txtCodeAttractionAdmin.getText(),Double.parseDouble(txtPriceAttractionAdmin.getText()),mfc.getArcade().getTypeConverter().stringToType(cbTypeAttractionAdmin.getValue()),attractionSelected);
            mfc.getArcade().getAjustableData().attractionAdjust(observableAttractions, txtNameAttractionAdmin, txtCodeAttractionAdmin, txtPriceAttractionAdmin, cbTypeAttractionAdmin, tableAttractionAdmin);
        }

    }

}
