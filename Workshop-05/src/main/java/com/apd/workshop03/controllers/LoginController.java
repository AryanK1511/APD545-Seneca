package com.apd.workshop03.controllers;

import com.apd.workshop03.models.Database;
import com.apd.workshop03.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if any fields are empty
        if (username.isEmpty() || password.isEmpty()) {
            showError("All fields must be filled!");
            return;
        }

        // Verify login credentials with Database
        User user = Database.getUser(username, password);
        if (user != null) {
            // Login successful
            System.out.println("Login successful for user: " + user.getUsername());
            Database.setCurrentUser(user);

            // Redirect to job postings page
            loadFXML("/com/apd/workshop03/job-postings.fxml", "Job Postings", event);
        } else {
            showError("Invalid username or password!");
        }
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        usernameField.clear();
        passwordField.clear();
        errorLabel.setText(""); // Clear error message
    }

    @FXML
    private void handleBackBtn(ActionEvent event) {
        loadFXML("/com/apd/workshop03/auth.fxml", "Home", event);
    }

    @FXML
    private void handleExitBtn(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void showError(String message) {
        errorLabel.setText(message);
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
