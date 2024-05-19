package com.application.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Vector;

public class MainViewController implements Initializable {
  // 1st Real Estate Listing
  @FXML
  private BorderPane listingPane1;
  @FXML
  private Text priceText1;
  @FXML
  private Text surfaceText1;
  @FXML
  private Text addressText1;
  @FXML
  private Text typeText1;

  // 2nd Real Estate Listing
  @FXML
  private BorderPane listingPane2;
  @FXML
  private Text priceText2;
  @FXML
  private Text surfaceText2;
  @FXML
  private Text addressText2;
  @FXML
  private Text typeText2;

  // 3rd Real Estate Listing
  @FXML
  private BorderPane listingPane3;
  @FXML
  private Text priceText3;
  @FXML
  private Text surfaceText3;
  @FXML
  private Text addressText3;
  @FXML
  private Text typeText3;

  // 1st Client Listing
  @FXML
  private BorderPane clientListing1;
  @FXML
  private Text clientFamilyName1;
  @FXML
  private Text clientFirstName1;
  @FXML
  private Text clientPhoneNumber1;

  // 2nd Client Listing
  @FXML
  private BorderPane clientListing2;
  @FXML
  private Text clientFamilyName2;
  @FXML
  private Text clientFirstName2;
  @FXML
  private Text clientPhoneNumber2;

  // 3rd Client Listing
  @FXML
  private BorderPane clientListing3;
  @FXML
  private Text clientFamilyName3;
  @FXML
  private Text clientFirstName3;
  @FXML
  private Text clientPhoneNumber3;

  // 1st Transaction Listing
  @FXML
  private SplitPane transactionListing1;
  @FXML
  private Text clientFullName1;
  @FXML
  private Text agentFullName1;
  @FXML
  private Text realEstateId1;
  @FXML
  private Text transactionType1;
  @FXML
  private Text transactionState1;
  @FXML
  private Text transactionDate1;

  // 2nd Transaction Listing
  @FXML
  private SplitPane transactionListing2;
  @FXML
  private Text clientFullName2;
  @FXML
  private Text agentFullName2;
  @FXML
  private Text realEstateId2;
  @FXML
  private Text transactionType2;
  @FXML
  private Text transactionState2;
  @FXML
  private Text transactionDate2;

  // 3rd Transaction Listing
  @FXML
  private SplitPane transactionListing3;
  @FXML
  private Text clientFullName3;
  @FXML
  private Text agentFullName3;
  @FXML
  private Text realEstateId3;
  @FXML
  private Text transactionType3;
  @FXML
  private Text transactionState3;
  @FXML
  private Text transactionDate3;

  // 1st Agent Listing
  @FXML
  private SplitPane agentListing1;
  @FXML
  private Text agentFamilyName1;
  @FXML
  private Text agentFirstName1;
  @FXML
  private Text agentPhoneNumber1;
  private Vector<String> agentRealEstates1;

  // 2nd Agent Listing
  @FXML
  private SplitPane agentListing2;
  @FXML
  private Text agentFamilyName2;
  @FXML
  private Text agentFirstName2;
  @FXML
  private Text agentPhoneNumber2;
  private Vector<String> agentRealEstates2;

  // 3rd Agent Listing
  @FXML
  private SplitPane agentListing3;
  @FXML
  private Text agentFamilyName3;
  @FXML
  private Text agentFirstName3;
  @FXML
  private Text agentPhoneNumber3;
  private Vector<String> agentRealEstates3;

  private int currentRealEstatePageIndex = 0;
  private int currentClientPageIndex = 0;
  private int currentTransactionPageIndex = 0;
  private int currentAgentPageIndex = 0;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    // Real Estate
    listingPane1.setDisable(true);
    listingPane1.setOpacity(0.0);
    listingPane2.setDisable(true);
    listingPane2.setOpacity(0.0);
    listingPane3.setDisable(true);
    listingPane3.setOpacity(0.0);
    // Clients
    clientListing1.setDisable(true);
    clientListing1.setOpacity(0.0);
    clientListing2.setDisable(true);
    clientListing2.setOpacity(0.0);
    clientListing3.setDisable(true);
    clientListing3.setOpacity(0.0);
    // Transactions
    transactionListing1.setDisable(true);
    transactionListing1.setOpacity(0.0);
    transactionListing2.setDisable(true);
    transactionListing2.setOpacity(0.0);
    transactionListing3.setDisable(true);
    transactionListing3.setOpacity(0.0);
    // Agents
    agentListing1.setDisable(true);
    agentListing1.setOpacity(0.0);
    agentListing2.setDisable(true);
    agentListing2.setOpacity(0.0);
    agentListing3.setDisable(true);
    agentListing3.setOpacity(0.0);
  }

  @FXML
  protected void onAddRealEstate(ActionEvent event) throws IOException {
    changeScene(event, "add-real-estate-listing-view.fxml");
  }

  @FXML
  protected void onAddClient(ActionEvent event) throws IOException {
    changeScene(event, "add-client-view.fxml");
  }
  @FXML
  protected void onResearchRealEstate(ActionEvent event) throws IOException {
    changeScene(event, "research-qurey-view.fxml");
  }

  @FXML
  protected void onModifyListing1() {

  }

  @FXML
  protected void onModifyListing2() {

  }

  @FXML
  protected void onModifyListing3() {

  }

  @FXML
  protected void onDeleteListing1() {

  }

  @FXML
  protected void onDeleteListing2() {

  }

  @FXML
  protected void onDeleteListing3() {

  }

  private void setListing1() {

  }

  private void setListing2() {

  }

  private void setListing3() {

  }

  private void changeScene(ActionEvent event, String sceneName) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(sceneName)));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

}