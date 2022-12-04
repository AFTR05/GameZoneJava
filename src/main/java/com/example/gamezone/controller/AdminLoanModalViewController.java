package com.example.gamezone.controller;

import com.example.gamezone.DTOs.LoanDTO;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Loan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminLoanModalViewController implements Initializable {


    private ModelFactoryController mfc=ModelFactoryController.getInstance();
    private Attraction selectAttraction;
    private LocalDate dateSelected;
    private ObservableList<LoanDTO> observableListLoanDTO= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mfc.getArcade().getChargerData().chargeData();
        selectAttraction=mfc.getArcade().getAdminLoanModalViewController().getSelectAttraction();
        dateSelected=mfc.getArcade().getAdminLoanModalViewController().getDateSelected();
        mfc.getArcade().getConvertToObservableList().loanDTOEmpObservable(selectAttraction,observableListLoanDTO,dateSelected,mfc.getArcade().getLoanService().getListLoans());
        mfc.getArcade().getPreparatorTable().prepareTableLoan(columnBeginHourLoan,columnEndHourLoan,columnAttractionLoan);
        tableModelClientSchedule.setItems(observableListLoanDTO);
    }

    public ModelFactoryController getMfc() {
        return mfc;
    }

    public void setMfc(ModelFactoryController mfc) {
        this.mfc = mfc;
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

    @FXML
    private TableColumn<LoanDTO, String> columnAttractionLoan;

    @FXML
    private TableColumn<LoanDTO, String> columnBeginHourLoan;

    @FXML
    private TableColumn<LoanDTO, String> columnEndHourLoan;

    @FXML
    private TableView<LoanDTO> tableModelClientSchedule;

}
