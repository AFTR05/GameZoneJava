package com.example.gamezone;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Employee;
import com.example.gamezone.service.impl.ClientServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    ModelFactoryController mfc=ModelFactoryController.getInstance();
    @Override
    public void start(Stage stage) throws IOException {
        mfc.getArcade().getChargerData().chargeData();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view/Login/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}