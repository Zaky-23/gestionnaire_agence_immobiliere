package com.application.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RealEstateResearchController implements Initializable {
  static private final String[] REAL_ESTATE_TYPES = {"Villa", "Appartement", "Studio", "Maison", "Bureau"};
  @FXML
  private TextField surfaceFieldMin;
  @FXML
  private TextField surfaceFieldMax;
  @FXML
  private TextField budgetFieldMin;
  @FXML
  private TextField budgetFieldMax;
  @FXML
  private ChoiceBox<String> typeChoiceBox;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    typeChoiceBox.getItems().addAll(REAL_ESTATE_TYPES);
  }

  @FXML
  protected void onCancel(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();
  }
}
