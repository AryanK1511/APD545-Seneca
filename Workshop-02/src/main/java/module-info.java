module com.apd.workshop02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.apd.workshop02 to javafx.fxml;
    exports com.apd.workshop02;
    exports com.apd.workshop02.controllers;
    opens com.apd.workshop02.controllers to javafx.fxml;
    exports com.apd.workshop02.models;
    opens com.apd.workshop02.models to javafx.fxml;
}