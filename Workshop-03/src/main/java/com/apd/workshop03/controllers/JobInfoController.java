package com.apd.workshop03.controllers;

import com.apd.workshop03.models.Applicant;
import com.apd.workshop03.models.Hashmap;
import com.apd.workshop03.models.JobRole;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JobInfoController {
    private final List<String> skills = new ArrayList<>();
    @FXML
    private Label jobInfoHeading;
    @FXML
    private Label jobInfoDesc;
    @FXML
    private Label deadlineDateLabel;
    @FXML
    private Label requiredSkillsLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Label applicationStatusLabel;
    @FXML
    private CheckBox googleCheckBox;
    @FXML
    private CheckBox microsoftCheckBox;
    @FXML
    private CheckBox metaCheckBox;
    @FXML
    private CheckBox appleCheckBox;
    @FXML
    private Button backButton;
    @FXML
    private FlowPane skillsFlowPane;
    private JobRole jobRole;

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
        jobInfoHeading.setText(jobRole.getJobName());
        jobInfoDesc.setText(jobRole.getDescription());
        deadlineDateLabel.setText("Deadline: " + jobRole.getDeadlineDate());
        requiredSkillsLabel.setText("Required Skills: " + jobRole.getRequiredSkills());
    }

    @FXML
    private void handleBackButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/apd/workshop03/job-postings.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleExitButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleApply() {
        if (nameField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || skills.isEmpty()) {
            applicationStatusLabel.setText("Error: All fields must be filled!");
            applicationStatusLabel.setTextFill(javafx.scene.paint.Color.RED);
            applicationStatusLabel.setVisible(true);
        } else {
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();

            Applicant applicant = new Applicant(name, phoneNumber, jobRole.getJobName());
            for (String skill : skills) {
                applicant.addSkill(skill);
            }

            List<String> selectedCompanies = new ArrayList<>();
            if (googleCheckBox.isSelected()) selectedCompanies.add("Google");
            if (microsoftCheckBox.isSelected()) selectedCompanies.add("Microsoft");
            if (metaCheckBox.isSelected()) selectedCompanies.add("Meta");
            if (appleCheckBox.isSelected()) selectedCompanies.add("Apple");

            applicant.setCompanies(selectedCompanies);

            Hashmap.addApplicant(applicant);

            System.out.println("Applicant Details:");
            System.out.println("Name: " + applicant.getName());
            System.out.println("Phone Number: " + applicant.getPhoneNumber());
            System.out.println("Skills: " + applicant.getSkills());
            System.out.println("Applied for: " + applicant.getJobRole());

            applicationStatusLabel.setText("Successfully applied for the job!");
            applicationStatusLabel.setTextFill(javafx.scene.paint.Color.GREEN);
            applicationStatusLabel.setVisible(true);

            clearForm();
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
        applicationStatusLabel.setVisible(false);
    }

    private void clearForm() {
        nameField.clear();
        phoneNumberField.clear();
        skills.clear();
        skillsFlowPane.getChildren().clear();
        googleCheckBox.setSelected(false);
        microsoftCheckBox.setSelected(false);
        metaCheckBox.setSelected(false);
        appleCheckBox.setSelected(false);
    }

    @FXML
    private void handleAddSkill() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Input Required");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter Skill");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(this::updateSkillsDisplay);
    }

    private void updateSkillsDisplay(String skill) {
        Label skillLabel = new Label(skill);
        skills.add(skill);
        skillLabel.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 5px; -fx-border-color: #ccc; -fx-border-radius: 3px;");
        skillLabel.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                handleEditSkill(skillLabel.getText());
            }
        });

        skillsFlowPane.getChildren().add(skillLabel);
    }

    private void handleEditSkill(String skill) {
        TextInputDialog dialog = new TextInputDialog(skill);
        dialog.setTitle("Edit Skill");
        dialog.setHeaderText(null);
        dialog.setContentText("Edit or Remove Skill:");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(newSkill -> {
            if (newSkill.isEmpty()) {
                skills.remove(skill);
                skillsFlowPane.getChildren().removeIf(node -> node instanceof Label && ((Label) node).getText().equals(skill));
            } else {
                skills.set(skills.indexOf(skill), newSkill);
                skillsFlowPane.getChildren().removeIf(node -> node instanceof Label && ((Label) node).getText().equals(skill));
                updateSkillsDisplay(newSkill);
            }
        });
    }

}
