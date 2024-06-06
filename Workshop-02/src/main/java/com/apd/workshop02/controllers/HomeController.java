package com.apd.workshop02.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

// ===== HOME CONTROLLER CLASS =====
public class HomeController {
    @FXML
    private Button userButton;

    @FXML
    private Button adminButton;

    @FXML
    public void initialize() {
        userButton.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/apd/workshop02/postings.fxml"));
                Scene secondPageScene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) userButton.getScene().getWindow();
                stage.setScene(secondPageScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        adminButton.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/apd/workshop02/admin.fxml"));
                Scene secondPageScene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) userButton.getScene().getWindow();
                stage.setScene(secondPageScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
