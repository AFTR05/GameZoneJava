package com.example.gamezone.utilities;

import javafx.scene.control.TextField;

public class DeleteInfoInputs {
    public void deleteInfo3TxtField(TextField textField1,TextField textField2,TextField textField3){
        textField1.setEditable(true);
        textField1.setText("");
        textField2.setEditable(true);
        textField2.setText("");
        textField3.setEditable(true);
        textField3.setText("");
    }
}
