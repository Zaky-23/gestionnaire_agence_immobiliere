package com.application.entities;

public class RealEstatePreferences {
    private int clientId;
    private int minSurface;
    private int maxSurface;
    private String address;
    private RealEstateType realEstateType;
    private double minBudget;
    private double maxBudget;

    public RealEstatePreferences(int clientId, int minSurface, int maxSurface, String address,
                                 RealEstateType realEstateType, double minBudget, double maxBudget) {
        this.clientId = clientId;
        this.minSurface = minSurface;
        this.maxSurface = maxSurface;
        this.address = address;
        this.realEstateType = realEstateType;
        this.minBudget = minBudget;
        this.maxBudget = maxBudget;
    }

    // Getters and setters
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getMinSurface() {
        return minSurface;
    }

    public void setMinSurface(int minSurface) {
        this.minSurface = minSurface;
    }

    public int getMaxSurface() {
        return maxSurface;
    }

    public void setMaxSurface(int maxSurface) {
        this.maxSurface = maxSurface;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RealEstateType getTypeOfRealEstate() {
        return realEstateType;
    }

    public void setTypeOfRealEstate(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }
    public double getMinBudget() {
        return minBudget;
    }
    public void setMinBudget(double minBudget) {
        this.minBudget = minBudget;
    }
    public double getMaxBudget() {
        return maxBudget;
    }
    public void setMaxBudget(double maxBudget) {
        this.maxBudget = maxBudget;
    }
}
