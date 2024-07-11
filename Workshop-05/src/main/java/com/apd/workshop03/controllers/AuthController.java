package com.apd.workshop03.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class AuthController {

    @FXML
    private void handleLoginBtn(ActionEvent event) {
        loadFXML("/com/apd/workshop03/login.fxml", "Login", event);
    }

    @FXML
    private void handleRegisterBtn(ActionEvent event) {
        loadFXML("/com/apd/workshop03/register.fxml", "Register", event);
    }

    @FXML
    private void handleBackBtn(ActionEvent event) {
        loadFXML("/com/apd/workshop03/home.fxml", "Home", event);
    }

    @FXML
    private void handleExitBtn(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void loadFXML(String fxmlFile, String title, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
