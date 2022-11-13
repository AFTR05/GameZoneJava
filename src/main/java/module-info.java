module com.example.gamezone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.gamezone to javafx.fxml;
    exports com.example.gamezone;
    exports com.example.gamezone.controller;
    opens com.example.gamezone.controller to javafx.fxml;

    opens com.example.gamezone.DTOs to javafx.fxml;
    exports com.example.gamezone.DTOs;
    exports com.example.gamezone.persistence;
    opens com.example.gamezone.persistence to javafx.fxml;
}