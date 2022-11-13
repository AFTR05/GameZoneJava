package com.example.gamezone;

import com.example.gamezone.DTOs.ClientDTO;
import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.persistence.PersistenceClient;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PracticeApplication extends javafx.application.Application{
    private static ModelFactoryController mfc=ModelFactoryController.getInstance();
    @Override
    public void start(Stage stage) throws IOException {
        try {
            mfc.getArcade().getPracticeCollectionService().setListClient(PersistenceClient.chargeClientDTO());
            Set<ClientDTO> hastClientDTO=new HashSet<ClientDTO>(mfc.getArcade().getPracticeCollectionService().getListClient());
            hastClientDTO.add(new ClientDTO("Sara",50));
            mfc.getArcade().getPracticeCollectionService().organizeByLetter(new ArrayList<>(hastClientDTO));
            mfc.getArcade().getPracticeCollectionService().limitJustOne(new ArrayList<>(hastClientDTO));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view/Practice.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
