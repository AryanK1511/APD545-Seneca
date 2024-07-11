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

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleRegisterButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Check if any fields are empty
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showError("All fields must be filled!");
            return;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match!");
            clearFields();
            return;
        }

        // Check if username already exists in the database
        if (Database.getUser(username, password) != null) {
            showError("Username already exists!");
            clearFields();
            return;
        }

        // If no errors, proceed with user registration
        User newUser = new User(username, password);
        Database.addUser(newUser);

        // Optionally, provide feedback to the user (e.g., success message)
        System.out.println("User registered successfully!");

        // Clear fields after successful registration
        clearFields();
        errorLabel.setText(""); // Clear error message
        // Redirect to the login page
        loadFXML("/com/apd/workshop03/login.fxml", "Home", event);
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        clearFields();
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

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
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
