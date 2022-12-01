package com.example.gamezone.utilities;

import com.example.gamezone.model.TypeAttraction;
import javafx.scene.control.ComboBox;

public class ComboBoxAdder {
    public void addComboBoxOptionsTypeAttraction(ComboBox comboBox) {
        comboBox.getItems().addAll(TypeAttraction.CONSOLE.getCategory(),TypeAttraction.PC.getCategory(),TypeAttraction.BOARDGAME.getCategory(), TypeAttraction.OTHER.getCategory());
    }
}
