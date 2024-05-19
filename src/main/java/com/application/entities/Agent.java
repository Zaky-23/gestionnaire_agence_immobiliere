package com.application.entities;
public class Agent {
    private int agentId;
    private String firstName;
    private String familyName;
    private int phoneNumber;

    // Constructor
    public Agent(int agentId, String firstName, String familyName, int phoneNumber) {
        this.agentId = agentId;
        this.firstName = firstName;
        this.familyName = familyName;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public int getAgentId() {
        return agentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
