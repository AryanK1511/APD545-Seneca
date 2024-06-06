/**********************************************
 Workshop # 02
 Course: APD545 - Semester 5
 Last Name: Khurana
 First Name: Aryan
 ID: 145282216
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Aryan Khurana
 Date: June 06, 2024
 **********************************************/

package com.apd.workshop02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// ===== MAIN CLASS =====
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Scene scene = new Scene(fxmlloader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}