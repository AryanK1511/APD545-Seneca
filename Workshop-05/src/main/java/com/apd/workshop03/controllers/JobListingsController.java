package com.apd.workshop03.controllers;


import com.apd.workshop03.models.JobRole;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.io.IOException;

// ===== JOB LISTINGS CONTROLLER CLASS =====
public class JobListingsController {
    @FXML
    private VBox jobListingsContainer;

    @FXML
    private Button backButton;

    @FXML
    // If the back button is clicked, go back to the home screen
    private void handleBackButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/apd/workshop03/home.fxml"));
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
    // If the exit button is clicked
    private void handleExitButton() {
        Stage stage = (Stage) jobListingsContainer.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        JobRole[] jobRoles = {
                new JobRole("Software Developer", "2024-06-30", "Develop and maintain software applications.", "Java, Spring Boot, SQL"),
                new JobRole("Project Manager", "2024-07-15", "Manage project timelines and deliverables.", "Agile, Scrum, Leadership"),
                new JobRole("ML Engineer", "2024-07-01", "Develop and deploy machine learning models.", "Python, TensorFlow, Data Science")
        };

        // Loop over the job roles and create a posting for each one of them
        for (JobRole jobRole : jobRoles) {
            Panel jobPanel = new Panel();
            jobPanel.getStyleClass().add("panel-primary");
            jobPanel.setPrefWidth(400);

            VBox jobContent = new VBox(10);
            jobContent.setPadding(new Insets(5));

            Label jobNameLabel = new Label(jobRole.getJobName());
            jobNameLabel.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

            Label deadlineDateLabel = new Label("Deadline: " + jobRole.getDeadlineDate());

            Label descriptionLabel = new Label(jobRole.getDescription());
            descriptionLabel.setStyle("-fx-font-size: 18px;");

            Label requiredSkillsLabel = new Label("Required Skills: " + jobRole.getRequiredSkills());

            Button applyButton = new Button("View Job and Apply");
            applyButton.getStyleClass().addAll("btn", "btn-lg", "btn-primary");

            applyButton.setOnAction(event -> showJobDetails(jobRole));

            jobContent.getChildren().addAll(jobNameLabel, descriptionLabel, deadlineDateLabel, requiredSkillsLabel, applyButton);
            jobPanel.setBody(jobContent);

            jobListingsContainer.getChildren().add(jobPanel);
        }
    }

    // Open the Job details page and let the users apply to the job that they clicked on
    private void showJobDetails(JobRole jobRole) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/apd/workshop03/job-info.fxml"));
            Parent jobDetailsRoot = loader.load();

            JobInfoController controller = loader.getController();
            controller.setJobRole(jobRole);

            Scene currentScene = backButton.getScene();
            currentScene.setRoot(jobDetailsRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
