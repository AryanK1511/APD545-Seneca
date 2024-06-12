package com.apd.workshop03.controllers;

import com.apd.workshop03.models.Hashmap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

// ===== ADMIN CONTROLLER CLASS =====
public class AdminController {
    @FXML
    private ListView<String> userListView;

    @FXML
    private Label noApplicantsLabel;

    @FXML
    private VBox adminContainer;

    @FXML
    private Button backButton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label skillsLabel;

    @FXML
    private Label companiesLabel;

    @FXML
    private void handleBackButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/apd/workshop03/home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage homepageStage = new Stage();
            homepageStage.setScene(scene);
            homepageStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleExitButton() {
        Stage stage = (Stage) adminContainer.getScene().getWindow();
        stage.close();
    }

    public void initialize() {
        if (Hashmap.getAllApplicants().isEmpty()) {
            noApplicantsLabel.setVisible(true);
        } else {
            ObservableList<String> users = FXCollections.observableArrayList(Hashmap.getAllApplicants().keySet());
            userListView.setItems(users);
        }
    }

    @FXML
    private void handleUserSelection() {
        String selectedName = userListView.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            nameLabel.setText("Name: " + selectedName);
            String phoneNumber = Hashmap.getApplicant(selectedName).getPhoneNumber();
            phoneNumberLabel.setText("Phone Number: " + phoneNumber);
            String skills = String.join(", ", Hashmap.getApplicant(selectedName).getSkills());
            skillsLabel.setText("Skills: " + skills);
            String companies = String.join(", ", Hashmap.getApplicant(selectedName).getCompanies());
            companiesLabel.setText("Preferred Companies: " + companies);
        }
    }
}
