module com.apd.workshop03 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.apd.workshop03 to javafx.fxml;
    exports com.apd.workshop03;
    exports com.apd.workshop03.controllers;
    opens com.apd.workshop03.controllers to javafx.fxml;
}