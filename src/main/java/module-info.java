module com.application.app {
  requires javafx.controls;
  requires javafx.fxml;

  requires com.dlsc.formsfx;
  requires java.sql;

  opens com.application.app to javafx.fxml;
  exports com.application.app;
}