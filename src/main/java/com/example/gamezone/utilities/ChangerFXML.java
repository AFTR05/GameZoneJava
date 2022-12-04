package com.example.gamezone.utilities;

import com.example.gamezone.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangerFXML {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void closeModalWindow(Button button){
        Stage stage=(Stage) button.getScene().getWindow();
        stage.close();
    }
    public void modalChange(String rute) throws IOException {
        root= FXMLLoader.load(Application.class.getResource(rute));
        stage=new Stage();
        scene=new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }


    public void sceneChange(ActionEvent event,String rute) throws IOException {
        root= FXMLLoader.load(Application.class.getResource(rute));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
