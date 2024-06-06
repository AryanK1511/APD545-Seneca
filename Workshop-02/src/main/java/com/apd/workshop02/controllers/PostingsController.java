package com.apd.workshop02.controllers;

import com.apd.workshop02.models.JobRole;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

// ===== POSTINGS CONTROLLER CLASS =====
public class PostingsController {
    @FXML
    private VBox jobPostingsContainer;

    @FXML
    private Button backButton;

    @FXML
    private void handleBackButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/apd/workshop02/homepage.fxml"));
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
        Stage stage = (Stage) jobPostingsContainer.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        JobRole[] jobRoles = {
                new JobRole("Software Developer", "2024-06-30", "Develop and maintain software applications.", "Java, Spring Boot, SQL"),
                new JobRole("Project Manager", "2024-07-15", "Manage project timelines and deliverables.", "Agile, Scrum, Leadership"),
                new JobRole("ML Engineer", "2024-07-01", "Develop and deploy machine learning models.", "Python, TensorFlow, Data Science")
        };

        for (JobRole jobRole : jobRoles) {
            VBox jobPostingBox = new VBox(5);
            jobPostingBox.setStyle("-fx-border-color: black; -fx-padding: 10; -fx-background-color: lightgray;");

            Label jobNameLabel = new Label("Job Name: " + jobRole.getJobName());
            Label deadlineDateLabel = new Label("Deadline: " + jobRole.getDeadlineDate());
            Label descriptionLabel = new Label("Description: " + jobRole.getDescription());
            Label requiredSkillsLabel = new Label("Required Skills: " + jobRole.getRequiredSkills());

            Button applyButton = new Button("View Job and Apply");

            applyButton.setOnAction(event -> showJobDetails(jobRole));

            jobPostingBox.getChildren().addAll(jobNameLabel, deadlineDateLabel, descriptionLabel, requiredSkillsLabel, applyButton);
            jobPostingsContainer.getChildren().add(jobPostingBox);
        }
    }

    private void showJobDetails(JobRole jobRole) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/apd/workshop02/job_details.fxml"));
            VBox jobDetailsRoot = loader.load();

            JobDetailsController controller = loader.getController();
            controller.setJobRole(jobRole);

            Stage stage = new Stage();
            stage.setTitle("Job Details");
            stage.setScene(new Scene(jobDetailsRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
