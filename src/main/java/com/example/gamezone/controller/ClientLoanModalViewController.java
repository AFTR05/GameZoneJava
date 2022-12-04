package com.example.gamezone.controller;

import com.example.gamezone.DTOs.LoanDTO;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Client;
import com.example.gamezone.service.impl.Arcade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import org.controlsfx.control.PropertySheet;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClientLoanModalViewController implements Initializable {
    public ModelFactoryController getMfc() {
        return mfc;
    }

    public void setMfc(ModelFactoryController mfc) {
        this.mfc = mfc;
    }

    private ModelFactoryController mfc=ModelFactoryController.getInstance();
    private LoanDTO loanDTOSelected;
    private Client meClient;
    private Attraction selectAttraction;
    private LocalDate dateSelected;
    private ObservableList<LoanDTO> observableListLoanDTO= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectAttraction=mfc.getArcade().getClientLoanModalViewController().getSelectAttraction();
        dateSelected=mfc.getArcade().getClientLoanModalViewController().getDateSelected();
        mfc.getArcade().getConvertToObservableList().loanDTOObservable(selectAttraction,observableListLoanDTO,dateSelected);
        mfc.getArcade().getConvertToObservableList().loanDTOLoanObservable(selectAttraction,observableListLoanDTO,dateSelected,mfc.getArcade().getLoanService().getListLoans());
        mfc.getArcade().getChargerData().chargeData();
        mfc.getArcade().getPreparatorTable().prepareTableLoan(columnBeginHourLoanClient,columnEndHourLoanClient,columnAttractionLoanClient);
        tableModelClientSchedule.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            loanDTOSelected =newSelection;
            mfc.getArcade().getShowInputs().showLoanDTOModal(txtAttractionNameModalSchedule,txtBeginHourLoanClient,txtEndHourLoanClient,loanDTOSelected);
        });
        tableModelClientSchedule.setItems(observableListLoanDTO);
    }

    public Attraction getSelectAttraction() {
        return selectAttraction;
    }

    public void setSelectAttraction(Attraction selectAttraction) {
        this.selectAttraction = selectAttraction;
    }

    public LocalDate getDateSelected() {
        return dateSelected;
    }

    public void setDateSelected(LocalDate dateSelected) {
        this.dateSelected = dateSelected;
    }

    public Client getMeClient() {
        return meClient;
    }

    public void setMeClient(Client meClient) {
        this.meClient = meClient;
    }
    @FXML
    private Button btnScheduleLoanClient;

    @FXML
    private TableColumn<LoanDTO, String> columnAttractionLoanClient;

    @FXML
    private TableColumn<LoanDTO, String> columnBeginHourLoanClient;

    @FXML
    private TableColumn<LoanDTO, String> columnEndHourLoanClient;

    @FXML
    private TableView<LoanDTO> tableModelClientSchedule;

    @FXML
    private Text txtAttractionNameModalSchedule;

    @FXML
    private Text txtBeginHourLoanClient;

    @FXML
    private Text txtEndHourLoanClient;

    @FXML
    void selectSchedule(ActionEvent event) {
        if (mfc.getArcade().getSelectValidator().validateLoanDTO(loanDTOSelected)){
            mfc.getArcade().getClientLoanViewController().setLoanDTOSelected(loanDTOSelected);
            mfc.getArcade().getClientLoanViewController().setAttractionSelected(selectAttraction);
            mfc.getArcade().getAlertGenerator().alertInformation("Success schedule selection","Success selection");
            mfc.getArcade().getChangerFXML().closeModalWindow(btnScheduleLoanClient);
        }
    }

}
