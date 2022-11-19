package com.example.gamezone.utilities;

import com.example.gamezone.model.Person;
import javafx.scene.control.TextField;

public class ShowInputs {
    public void showInProfile(TextField textFieldName, TextField textFieldEmail, TextField textFieldPassword, Person person){
        textFieldName.setText(person.getName());
        textFieldEmail.setText(person.getEmail());
        textFieldPassword.setText(person.getPassword());
    }
}
