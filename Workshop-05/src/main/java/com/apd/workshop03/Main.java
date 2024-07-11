/**********************************************
 Workshop # 05
 Course: APD545 - Semester 5
 Last Name: Khurana
 First Name: Aryan
 ID: 145282216
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Aryan Khurana
 Date: July 08, 2024
 **********************************************/

package com.apd.workshop03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("home.fxml"));
            Scene scene = new Scene(fxmlloader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
