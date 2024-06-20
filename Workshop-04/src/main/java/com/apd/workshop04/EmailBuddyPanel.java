package com.apd.workshop04;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

// ===== EMAIL BUDDY APPLICATION HOMEPAGE =====
public class EmailBuddyPanel extends GridPane {
    private final EmailBuddyList model;
    private final ListView<EmailBuddy> buddyList;
    private final Button addButton;
    private final Button removeButton;
    private final CheckBox hotListButton;

    public EmailBuddyPanel(EmailBuddyList m) {
        model = m;
        setPadding(new Insets(10, 10, 10, 10));

        buddyList = new ListView<EmailBuddy>();
        buddyList.setItems(FXCollections.observableArrayList(m.getEmailBuddies()));
        add(buddyList, 0, 0, 1, 3);
        buddyList.setPrefHeight(Integer.MAX_VALUE);
        buddyList.setMinWidth(200);
        buddyList.setPrefWidth(Integer.MAX_VALUE);

        addButton = new Button("Add");
        add(addButton, 1, 0);
        setMargin(addButton, new Insets(0, 0, 10, 10));
        setValignment(addButton, VPos.TOP);
        setHalignment(addButton, HPos.CENTER);
        addButton.setMinHeight(25);
        addButton.setMinWidth(100);
        removeButton = new Button("Remove");
        add(removeButton, 1, 1);
        setMargin(removeButton, new Insets(0, 0, 10, 10));
        setValignment(removeButton, VPos.TOP);
        setHalignment(removeButton, HPos.CENTER);
        removeButton.setMinHeight(25);
        removeButton.setMinWidth(100);
        hotListButton = new CheckBox("Show Hot List");
        add(hotListButton, 1, 2);
        setMargin(hotListButton, new Insets(0, 0, 10, 10));
        setValignment(hotListButton, VPos.TOP);
        setHalignment(hotListButton, HPos.CENTER);
        hotListButton.setMinHeight(25);
        hotListButton.setMinWidth(100);

        update();
    }

    public ListView<EmailBuddy> getBuddyList() {
        return buddyList;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public CheckBox getHotListButton() {
        return hotListButton;
    }

    public void update() {

        int selectedItem = buddyList.getSelectionModel().getSelectedIndex();

        EmailBuddy[] exactList;

        if (hotListButton.isSelected()) {
            exactList = new EmailBuddy[model.getHotListSize()];

            for (int i = 0; i < model.getHotListSize(); i++)
                exactList[i] = model.getHotListBuddy(i);

        } else {
            exactList = new EmailBuddy[model.getSize()];

            for (int i = 0; i < model.getSize(); i++)
                exactList[i] = model.getBuddy(i);

        }

        buddyList.setItems(null);
        buddyList.setItems(FXCollections.observableArrayList(exactList));

        buddyList.getSelectionModel().select(selectedItem);

        removeButton.setDisable(buddyList.getSelectionModel().getSelectedIndex() < 0);
    }
}