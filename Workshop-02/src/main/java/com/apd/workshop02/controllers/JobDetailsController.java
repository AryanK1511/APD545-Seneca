package com.apd.workshop02.controllers;

import com.apd.workshop02.models.Admin;
import com.apd.workshop02.models.Applicant;
import com.apd.workshop02.models.JobRole;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// ===== JOB DETAILS CONTROLLER CLASS =====
public class JobDetailsController {
    @FXML
    private Label jobNameLabel;

    @FXML
    private Label deadlineDateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label requiredSkillsLabel;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextArea skillsField;

    @FXML
    private Label applicationStatusLabel;

    @FXML
    private Button applyButton;

    @FXML
    private CheckBox googleCheckBox;

    @FXML
    private CheckBox microsoftCheckBox;

    @FXML
    private CheckBox metaCheckBox;

    @FXML
    private CheckBox appleCheckBox;

    private JobRole jobRole;

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
        jobNameLabel.setText("Job Name: " + jobRole.getJobName());
        deadlineDateLabel.setText("Deadline: " + jobRole.getDeadlineDate());
        descriptionLabel.setText("Description: " + jobRole.getDescription());
        requiredSkillsLabel.setText("Required Skills: " + jobRole.getRequiredSkills());
    }

    @FXML
    private void handleApply() {
        if (nameField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || skillsField.getText().isEmpty()) {
            applicationStatusLabel.setText("Error: All fields must be filled!");
            applicationStatusLabel.setTextFill(javafx.scene.paint.Color.RED);
            applicationStatusLabel.setVisible(true);
        } else {
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String skillsInput = skillsField.getText();
            String[] skillsArray = skillsInput.split(",");

            Applicant applicant = new Applicant(name, phoneNumber, jobRole.getJobName());
            for (String skill : skillsArray) {
                applicant.addSkill(skill.trim());
            }

            List<String> selectedCompanies = new ArrayList<>();
            if (googleCheckBox.isSelected()) selectedCompanies.add("Google");
            if (microsoftCheckBox.isSelected()) selectedCompanies.add("Microsoft");
            if (metaCheckBox.isSelected()) selectedCompanies.add("Meta");
            if (appleCheckBox.isSelected()) selectedCompanies.add("Apple");

            applicant.setCompanies(selectedCompanies);

            Admin.addApplicant(applicant);

            System.out.println("Applicant Details:");
            System.out.println("Name: " + applicant.getName());
            System.out.println("Phone Number: " + applicant.getPhoneNumber());
            System.out.println("Skills: " + applicant.getSkills());
            System.out.println("Applied for: " + applicant.getJobRole());

            applicationStatusLabel.setText("Successfully applied for the job!");
            applicationStatusLabel.setTextFill(javafx.scene.paint.Color.GREEN);
            applicationStatusLabel.setVisible(true);

            nameField.clear();
            phoneNumberField.clear();
            skillsField.clear();
            googleCheckBox.setSelected(false);
            microsoftCheckBox.setSelected(false);
            metaCheckBox.setSelected(false);
            appleCheckBox.setSelected(false);
        }
    }

    @FXML
    private void handleClear() {
        applicationStatusLabel.setVisible(false);
        nameField.clear();
        phoneNumberField.clear();
        skillsField.clear();
        googleCheckBox.setSelected(false);
        microsoftCheckBox.setSelected(false);
        metaCheckBox.setSelected(false);
        appleCheckBox.setSelected(false);
    }

    @FXML
    private void handleClose() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}
