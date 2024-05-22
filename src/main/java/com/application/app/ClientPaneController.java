package com.application.app;

import com.application.entities.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClientPaneController implements Initializable {
  static private final String[] REAL_ESTATE_TYPES = {"Villa", "Appartement", "Studio", "Maison", "Bureau"};

  @FXML
  private TextField familyNameField;
  @FXML
  private TextField firstNameField;
  @FXML
  private TextField phoneNumberField;
  @FXML
  private TextField minSurfaceField;
  @FXML
  private TextField maxSurfaceField;
  @FXML
  private TextField minBudgetField;
  @FXML
  private TextField maxBudgetField;
  @FXML
  private ChoiceBox<String> realEstateTypeChoiceBox;
  @FXML
  private TextArea localisationField;

  static public Client returnValue;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    // App doesn't work, says it's null but IT'S NOt
    // Must leave it like this to work
    // Can't be bothered to fix it
    // If it works, leave it
    try {
      realEstateTypeChoiceBox.getItems().addAll(REAL_ESTATE_TYPES);
    } finally {

    }
  }

  @FXML
  public void onApply() {
    returnValue = new Client(0, firstNameField.getText(), familyNameField.getText(), phoneNumberField.getText(), "");
  }

  public Client getReturnValue() {
    return returnValue;
  }

  @FXML
  public void onCancel(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();
  }
}
