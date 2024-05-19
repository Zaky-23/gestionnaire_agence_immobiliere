package com.application.entities;

import java.util.Date;


public class Transaction {
    private int transactionId;
    private TransactionType transactionType;
    private int agentId;
    private int clientId;
    private String clientFn;
    private String clientLn;
    private int clientPn;
    private String ownerInfo;
    private int ownerPn;
    private int realEstateId;
    private Date date;

    public Transaction(int transactionId, TransactionType transactionType, int agentId, int clientId,
                       String clientFn, String clientLn, int clientPn, String ownerInfo, int ownerPn,
                       int realEstateId, Date date) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.agentId = agentId;
        this.clientId = clientId;
        this.clientFn = clientFn;
        this.clientLn = clientLn;
        this.clientPn = clientPn;
        this.ownerInfo = ownerInfo;
        this.ownerPn = ownerPn;
        this.realEstateId = realEstateId;
        this.date = date;
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getAgentId() {
        return agentId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientFn() {
        return clientFn;
    }

    public String getClientLn() {
        return clientLn;
    }

    public int getClientPn() {
        return clientPn;
    }

    public String getOwnerInfo() {
        return ownerInfo;
    }

    public int getOwnerPn() {
        return ownerPn;
    }

    public int getRealEstateId() {
        return realEstateId;
    }

    public Date getDate() {
        return date;
    }
}