package com.apd.workshop04;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

// ===== BUDDY DETAIL DIALOG BOX CLASS =====
public class BuddyDetailsDialog extends Dialog<EmailBuddy> {
    public BuddyDetailsDialog(Stage owner, String title, EmailBuddy bud) {
        setTitle(title);

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        TextField nameField = new TextField(bud.getName());
        nameField.setPromptText("Person's name to be shown in the list");
        nameField.setMinWidth(300);

        TextField addressField = new TextField(bud.getAddress());
        addressField.setPromptText("Enter a valid email address");
        addressField.setMinWidth(300);

        CheckBox onHotList = new CheckBox("On Hot List");
        onHotList.setSelected(bud.onHotList());

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Address:"), 0, 1);
        grid.add(addressField, 1, 1);
        grid.add(onHotList, 1, 2);
        getDialogPane().setContent(grid);

        // Convert the result to an EmailBuddy containing the info
        setResultConverter(new Callback<ButtonType, EmailBuddy>() {
            public EmailBuddy call(ButtonType b) {
                if (b == okButtonType) {
                    bud.setName(nameField.getText());
                    bud.setAddress(addressField.getText());
                    bud.onHotList(onHotList.isSelected());
                    return bud;
                }
                return null;
            }
        });

        Node okButton = getDialogPane().lookupButton(okButtonType);
        okButton.setDisable(true);

        Runnable updateOkButtonState = () ->
                okButton.setDisable(nameField.getText().trim().isEmpty() || addressField.getText().trim().isEmpty());

        nameField.textProperty().addListener((observable, oldValue, newValue) -> updateOkButtonState.run());
        addressField.textProperty().addListener((observable, oldValue, newValue) -> updateOkButtonState.run());

        onHotList.selectedProperty().addListener((observable, oldValue, newValue) -> updateOkButtonState.run());
    }
}
