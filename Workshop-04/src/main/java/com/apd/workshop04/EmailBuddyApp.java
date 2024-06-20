package com.apd.workshop04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;

// ===== MAIN APPLICATION =====
public class EmailBuddyApp extends Application {
    private EmailBuddyList model;
    private EmailBuddyPanel view;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        model = new EmailBuddyList();
        view = new EmailBuddyPanel(model);

        view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                EmailBuddy aBuddy = new EmailBuddy();

                Dialog dialog = new BuddyDetailsDialog(primaryStage,
                        "New Buddy Details", aBuddy);

                Optional<EmailBuddy> result = dialog.showAndWait();

                if (result.isPresent()) {
                    model.add(aBuddy);
                    view.update();
                }
            }
        });

        view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                int index = view.getBuddyList().getSelectionModel().getSelectedIndex();
                if (index >= 0) {
                    model.remove(index);
                    view.update();
                }
            }
        });

        view.getHotListButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.update();
            }
        });

        view.getBuddyList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    EmailBuddy selectedBuddy;
                    int selectedIndex = view.getBuddyList().getSelectionModel().
                            getSelectedIndex();
                    if (selectedIndex >= 0) {
                        if (view.getHotListButton().isSelected()) selectedBuddy =
                                model.getHotListBuddy(selectedIndex);
                        else selectedBuddy = model.getBuddy(selectedIndex);
                        if (selectedBuddy == null) return;
                        Dialog dialog = new BuddyDetailsDialog(primaryStage, "Edit Buddy Details", selectedBuddy);
                        Optional<EmailBuddy> result = dialog.showAndWait();

                        if (result.isPresent()) {
                            view.update();
                        }
                    }
                } else {
                    view.update();
                }
            }
        });

        primaryStage.setTitle("Email Buddy App");
        primaryStage.setScene(new Scene(view, 400, 300));
        primaryStage.show();
    }
}