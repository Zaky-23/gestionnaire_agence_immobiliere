package com.application.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Vector;

public class RealEstatePaneController implements Initializable {
  static private final String[] REAL_ESTATE_TYPES = {"Villa", "Appartement", "Studio", "Maison", "Bureau"};
  static private final String[] TRANSACTION_TYPE = {"Vente", "Location"};
  static private Vector<String> agents;

  // Add RealEstate Pane
  @FXML
  private TextField priceField;
  @FXML
  private TextField surfaceField;
  @FXML
  private TextField addressField;
  @FXML
  private ChoiceBox<String> realEstateTypeChoiceBox;
  @FXML
  private ChoiceBox<String> transactionTypeChoiceBox;
  @FXML
  private TextArea descriptionField;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    realEstateTypeChoiceBox.getItems().addAll(REAL_ESTATE_TYPES);
    transactionTypeChoiceBox.getItems().addAll(TRANSACTION_TYPE);
    agents = new Vector<>();
  }
  @FXML
  public void onCancel(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void onApply() {
    float price = 0;
    float surface = 0;
    String address;
    String realEstateType;
    String description;
    String transactionType;

    try {
      price = Float.parseFloat(priceField.textProperty().getValue());
    } catch (Exception e) {
      priceField.setText("Valeur non-valide");
    }
    try {
      surface = Float.parseFloat(surfaceField.textProperty().getValue());
    } catch (Exception e) {
      surfaceField.setText("Valeur non-valide");
    }

    address = addressField.textProperty().getValue();
    if (address.isEmpty()) {
      addressField.setText("Valeur non-valide");
      return;
    }

    realEstateType = realEstateTypeChoiceBox.getValue();
    if (realEstateType.isEmpty()) {
      return;
    }

    description = descriptionField.getText();
    if(description.isEmpty()) {
      return;
    }
    transactionType = transactionTypeChoiceBox.getValue();
    if (transactionType.isEmpty()) {
      // TODO: do something
    }
  }
}
