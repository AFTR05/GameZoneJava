package com.example.gamezone.utilities;

import com.example.gamezone.DTOs.AttractionDTO;
import com.example.gamezone.DTOs.EmployeeDTO;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.model.Employee;
import com.example.gamezone.model.Person;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ShowInputs {
    public void showInProfile(TextField textFieldName, TextField textFieldEmail, TextField textFieldPassword, Person person){
        textFieldName.setText(person.getName());
        textFieldEmail.setText(person.getEmail());
        textFieldPassword.setText(person.getPassword());
    }

    public void showEmployeeInformation(Employee employeeSelected, TextField txtName, TextField txtEmail, TextField txtPassword){
        if(employeeSelected != null){
            txtName.setText(employeeSelected.getName());
            txtName.setEditable(false);
            txtEmail.setText(employeeSelected.getEmail());
            txtEmail.setEditable(false);
            txtPassword.setText(employeeSelected.getPassword());
            txtPassword.setEditable(false);
        }
    }

    public void showAttraction(AttractionDTO attractionSelected, TextField txtName, TextField txtCode, TextField txtPrice, ComboBox comboBoxType){
        if(attractionSelected!=null){
            txtName.setText(attractionSelected.getName());
            txtCode.setText(attractionSelected.getCode());
            txtPrice.setText(String.valueOf(attractionSelected.getPrice()));
            comboBoxType.setValue(attractionSelected.getCategory());
        }
    }
    public void showEmployeeDTO(EmployeeDTO employeeSelected, Text txtName, Text txtEmail, TextField txtSalary){
        if(employeeSelected != null){
            txtName.setText(employeeSelected.getName());
            txtEmail.setText(employeeSelected.getEmail());
            txtSalary.setText(String.valueOf(employeeSelected.getSalary()));
        }
    }


}
