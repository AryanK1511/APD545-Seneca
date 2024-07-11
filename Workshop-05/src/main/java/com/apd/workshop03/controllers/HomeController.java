package com.apd.workshop03.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

// ===== HOME CONTROLLER CLASS =====
public class HomeController {
    @FXML
    private Button userButton;

    @FXML
    private Button adminButton;

    @FXML
    public void initialize() {
        // Load the postings page if the user button is clicked
        userButton.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/apd/workshop03/auth.fxml"));
                Scene secondPageScene = new Scene(fxmlLoader.load());
                secondPageScene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                Stage stage = (Stage) userButton.getScene().getWindow();
                stage.setScene(secondPageScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Load the admin page if the admin button is clicked
        adminButton.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/apd/workshop03/admin-view.fxml"));
                Scene secondPageScene = new Scene(fxmlLoader.load());
                secondPageScene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                Stage stage = (Stage) userButton.getScene().getWindow();
                stage.setScene(secondPageScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
