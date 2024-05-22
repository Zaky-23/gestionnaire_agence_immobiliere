package com.application.app;

import com.application.entities.Client;
import com.application.faker.Faker;
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
    setClientListing1();
    setClientListing2();
    setClientListing3();
    // Transactions
    transactionListing1.setDisable(true);
    transactionListing1.setOpacity(0.0);
    transactionListing2.setDisable(true);
    transactionListing2.setOpacity(0.0);
    transactionListing3.setDisable(true);
    transactionListing3.setOpacity(0.0);
    // Agents

    setAgentListing1();
    setAgentListing2();
    setAgentListing3();

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

  private int currentRealEstatePageIndex = 0;
  private void setRealEstateListing1() {
    var realEstate = Faker.realEstates.get(currentAgentPageIndex + 0);
    if (realEstate != null) {
      priceText1.setText(String.valueOf(realEstate.getPrice()));
      surfaceText1.setText(String.valueOf(realEstate.getSurface()));

    } else {

    }
  }

  private void setRealEstateListing2() {

  }

  private void setRealEstateListing3() {

  }

  private int currentClientPageIndex = 0;
  @FXML
  protected void onModifyClientListing1(ActionEvent event) throws IOException {
  }

  @FXML
  protected void onModifyClientListing2(ActionEvent event) throws IOException {
  }

  @FXML
  protected void onModifyClientListing3(ActionEvent event) throws IOException {
  }

  @FXML
  protected void onDeleteClientListing1() {
    Faker.clients.remove(currentClientPageIndex * 3 + 0);
    setClientListing1();
    setClientListing2();
    setClientListing3();
  }

  @FXML
  protected void onDeleteClientListing2() {
    Faker.clients.remove(currentClientPageIndex * 3 + 1);
    setClientListing1();
    setClientListing2();
    setClientListing3();
  }

  @FXML
  protected void onDeleteClientListing3() {
    Faker.clients.remove(currentClientPageIndex * 3 + 2);
    setClientListing1();
    setClientListing2();
    setClientListing3();
  }
  @FXML
  protected void onClientPaneNext() {
    if (currentClientPageIndex + 1 > Faker.clients.size() / 3) {
      return;
    }

    currentClientPageIndex += 1;
    setClientListing1();
    setClientListing2();
    setClientListing3();
  }

  @FXML
  protected void onClientPanePrevious() {
    currentClientPageIndex -= 1;

    if (currentClientPageIndex < 0) {
      currentClientPageIndex = 0;
    }
    setClientListing1();
    setClientListing2();
    setClientListing3();
  }
  private void setClientListing1() {
    Client client = null;
    try {
      client = Faker.clients.get(currentClientPageIndex + 0);
    } catch (Exception e) {
      clientListing1.setDisable(true);
      clientListing1.setOpacity(0.0);
      return;
    }

    clientListing1.setDisable(false);
    clientListing1.setOpacity(1.0);
    clientFirstName1.setText(client.getFamilyName());
    clientFamilyName1.setText(client.getFamilyName());
  }

  private void setClientListing2() {
    Client client = null;
    try {
      client = Faker.clients.get(currentClientPageIndex + 1);
    } catch (Exception e) {
      clientListing2.setDisable(true);
      clientListing2.setOpacity(0.0);
      return;
    }

    clientListing2.setDisable(false);
    clientListing2.setOpacity(1.0);
    clientFirstName2.setText(client.getFamilyName());
    clientFamilyName2.setText(client.getFamilyName());
  }

  private void setClientListing3() {
    Client client = null;
    try {
      client = Faker.clients.get(currentClientPageIndex + 2);
    } catch (Exception e) {
      clientListing3.setDisable(true);
      clientListing3.setOpacity(0.0);
      return;
    }

    clientListing3.setDisable(false);
    clientListing3.setOpacity(1.0);
    clientFirstName3.setText(client.getFamilyName());
    clientFamilyName3.setText(client.getFamilyName());
  }

  private int currentTransactionPageIndex = 0;
  private void setTransactionListing1() {

  }

  private void setTransactionListing2() {

  }

  private void setTransactionListing3() {

  }

  private int currentAgentPageIndex = 0;
  @FXML
  protected void onAgentPaneNext() {
    if (currentAgentPageIndex + 1 > Faker.agents.size() / 3) {
      return;
    }

    currentAgentPageIndex += 1;
    setAgentListing1();
    setAgentListing2();
    setAgentListing3();
  }

  @FXML
  protected void onAgentPanePrevious() {
    currentAgentPageIndex -= 1;

    if (currentAgentPageIndex < 0) {
      currentAgentPageIndex = 0;
    }
    setAgentListing1();
    setAgentListing2();
    setAgentListing3();
  }

  private void setAgentListing1() {
    var agent = Faker.agents.get(currentAgentPageIndex + 0);
    if(agent != null) {
      agentListing1.setDisable(false);
      agentListing1.setOpacity(1.0);
      agentFirstName1.setText(agent.getFirstName());
      agentFamilyName1.setText(agent.getFamilyName());
      agentPhoneNumber1.setText(agent.getPhoneNumber());
    } else {
      agentListing1.setDisable(true);
      agentListing1.setOpacity(0.0);
    }
  }

  private void setAgentListing2() {
    var agent = Faker.agents.get(currentAgentPageIndex + 1);
    if( agent != null) {
      agentListing2.setDisable(false);
      agentListing2.setOpacity(1.0);
      agentFirstName2.setText(agent.getFirstName());
      agentFamilyName2.setText(agent.getFamilyName());
      agentPhoneNumber2.setText(agent.getPhoneNumber());
    } else {
      agentListing2.setDisable(true);
      agentListing2.setOpacity(0.0);
    }
  }

  private void setAgentListing3() {
    var agent = Faker.agents.get(currentAgentPageIndex + 2);
    if( agent != null) {
      agentListing3.setDisable(false);
      agentListing3.setOpacity(1.0);
      agentFirstName3.setText(agent.getFirstName());
      agentFamilyName3.setText(agent.getFamilyName());
      agentPhoneNumber3.setText(agent.getPhoneNumber());
    } else {
      agentListing3.setDisable(true);
      agentListing3.setOpacity(0.0);
    }
  }

  private void changeScene(ActionEvent event, String sceneName) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(sceneName)));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

}