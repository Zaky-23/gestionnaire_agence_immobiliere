package com.application.entities;
public class Client {
    private int clientId;
    private String firstName;
    private String familyName;
    private String phoneNumber;
    private String clientType;
    private RealEstatePreferences clientPreferences;

    public Client(String firstName, String familyName, String phoneNumber) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public RealEstatePreferences getClientPreferences() {
        return clientPreferences;
    }

    public void setClientPreferences(RealEstatePreferences clientPreferences) {
        this.clientPreferences = clientPreferences;
    }

}

