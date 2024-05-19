package com.application.entities;

public class RealEstate {
    private int realEstateId;
    private TransactionType transactionType;
    private RealEstateType realEstateType;
    private int surface;
    private double price;
    private String address;
    private int floors;
    private boolean hasContract;
    private boolean pool;
    private int agentId;
    private int numberOfRooms;
    private int trscId;
    private String description;

    // Constructor
    public RealEstate(int realEstateId, TransactionType transactionType, RealEstateType realEstateType, int surface, double price,
                      String address, int floors, boolean hasContract, boolean pool, int agentId,
                      int numberOfRooms, int trscId, String description) {
        this.realEstateId = realEstateId;
        this.transactionType = transactionType;
        this.realEstateType = realEstateType;
        this.surface = surface;
        this.price = price;
        this.address = address;
        this.floors = floors;
        this.hasContract = hasContract;
        this.pool = pool;
        this.agentId = agentId;
        this.numberOfRooms = numberOfRooms;
        this.trscId = trscId;
        this.description = description;
    }

    // Getters and Setters
    public int getRealEstateId() {
        return realEstateId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public int getSurface() {
        return surface;
    }

    public double getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public boolean isHasContract() {
        return hasContract;
    }

    public boolean isPool() {
        return pool;
    }

    public int getAgentId() {
        return agentId;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getTrscId() {
        return trscId;
    }

    public String getDescription() {
        return description;
    }
}