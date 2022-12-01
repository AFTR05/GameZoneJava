package com.example.gamezone.utilities;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DeleteInfoInputs {
    public void deleteInfo3TxtField(TextField textField1,TextField textField2,TextField textField3){
        textField1.setEditable(true);
        textField1.setText("");
        textField2.setEditable(true);
        textField2.setText("");
        textField3.setEditable(true);
        textField3.setText("");
    }

    public void deleteWithComboBox(TextField textField1, TextField textField2, TextField textField3, ComboBox comboBox){
        textField1.setEditable(true);
        textField1.setText("");
        textField2.setEditable(true);
        textField2.setText("");
        textField3.setEditable(true);
        textField3.setText("");
        comboBox.setValue("Type");
    }

    public void  deleteText3Field(TextField textField1, Text text2, Text text3){
        textField1.setEditable(true);
        textField1.setText("");
        text2.setText("");
        text3.setText("");
    }
}
