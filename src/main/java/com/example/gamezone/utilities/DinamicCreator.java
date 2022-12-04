package com.example.gamezone.utilities;

import com.example.gamezone.controller.ModelFactoryController;
import com.example.gamezone.model.Attraction;
import com.example.gamezone.service.impl.Arcade;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import org.controlsfx.control.PropertySheet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class DinamicCreator {

        public Button createButton(Attraction attraction, DatePicker datePicker, ModelFactoryController mfc){
        File file=new File(attraction.getTypeAttraction().getImage());
        ImageView imageView=new ImageView(new Image(file.toURI().toString()));
        Button button=new Button();
        button.setPrefHeight(70);
        button.setPrefWidth(70);
        button.setCursor(Cursor.HAND);
        button.setId(attraction.getCode());
        button.setOnAction(event -> {
            try {
                if (mfc.getArcade().getTimeValidator().validateDatePicker(datePicker)){
                    mfc.getArcade().getClientLoanModalViewController().setMfc(mfc);
                    mfc.getArcade().getClientLoanModalViewController().setSelectAttraction(mfc.getArcade().getSercherObject().getAttraction(button.getId(),mfc.getArcade().getAttractionService().getAttractions()));
                    mfc.getArcade().getClientLoanModalViewController().setDateSelected(datePicker.getValue());
                    mfc.getArcade().getChangerFXML().modalChange("view/Client/ClientLoanModalView.fxml");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        imageView.prefHeight(53);
        imageView.prefWidth(42);
        button.setStyle("-fx-background-color: transparent;");
        button.setGraphic(imageView);
        return button;
    }

    public VBox createVbox(){
        VBox vBox=new VBox();
        vBox.setPrefHeight(80);
        vBox.setPrefWidth(70);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    public HBox createHbox(){
        HBox hBox=new HBox();
        hBox.setPrefHeight(80);
        hBox.setPrefWidth(70);
        hBox.setSpacing(60);
        return hBox;
    }

    public Text createTextName(Attraction attraction){
        Text text=new Text(attraction.getName());
        text.setFill(Paint.valueOf("white"));
        return text;
    }

    public Text createTextPrice(Attraction attraction){
        Text text=new Text("$"+Double.valueOf(attraction.getPrice()));
        text.setFill(Paint.valueOf("white"));
        return text;
    }

    public void putOnDataAttraction(HashSet<Attraction> attractionsHash, VBox vBoxPrincipal,DatePicker datePicker,ModelFactoryController mfc){
        ArrayList<Attraction> attractions=new ArrayList<Attraction>(attractionsHash);
        int x=0;
        while (x<attractions.size()){
            HBox hBox=createHbox();
            individual:for (int y=0;y<5;y++){
                VBox vBox=createVbox();
                vBox.getChildren().add(createTextName(attractions.get(x)));
                vBox.getChildren().add(createButton(attractions.get(x),datePicker,mfc));
                vBox.getChildren().add(createTextPrice(attractions.get(x)));
                hBox.getChildren().add(vBox);
                x++;
                if (x==attractions.size()){
                    break individual;
                }
            }
            vBoxPrincipal.getChildren().add(hBox);
        }
    }
}
