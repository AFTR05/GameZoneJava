package com.example.gamezone.utilities;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PreparatorTable {
    public void prepareTableClient(TableColumn tableNameColumn, TableColumn tableEmailColumn, TableColumn tableAmountColumn){
        tableNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amountLoan"));
    }

    public void prepareTableLoan(TableColumn tableBeginColumn, TableColumn tableEndColumn, TableColumn tableNameColumn){
        tableNameColumn.setCellValueFactory(new PropertyValueFactory<>("nameAttraction"));
        tableBeginColumn.setCellValueFactory(new PropertyValueFactory<>("beginHour"));
        tableEndColumn.setCellValueFactory(new PropertyValueFactory<>("endHour"));
    }

    public void prepareTablePerson(TableColumn tableNameColumn, TableColumn tableEmailColumn, TableColumn tablePasswordColumn){
        tableNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tablePasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
    }

    public void prepareTableEmployeeDTO(TableColumn tableNameColumn, TableColumn tableEmailColumn, TableColumn tableSalaryColumn){
        tableNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    public void preparateTableAttraction(TableColumn tableNameColumn, TableColumn tableCodeColumn,TableColumn tableTypeColumn, TableColumn tablePriceColumn){
        tableNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCodeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        tableTypeColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        tablePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void refreshTable(ObservableList observableList, TableView tableView){
        tableView.setItems(observableList);
        tableView.refresh();
    }
}
