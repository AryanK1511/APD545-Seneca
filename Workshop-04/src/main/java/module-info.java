module com.apd.workshop04 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.apd.workshop04 to javafx.fxml;
    exports com.apd.workshop04;
}