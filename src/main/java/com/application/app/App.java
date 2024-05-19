package com.application.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader mainViewLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
    Scene mainScene = new Scene(mainViewLoader.load(), 800, 600);
    stage.setTitle("Dynasty 8 | Real Estate Management App");
    stage.setScene(mainScene);
    stage.resizableProperty().set(false);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}