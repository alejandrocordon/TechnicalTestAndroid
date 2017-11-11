package com.test.alejandrocordonurena.technicaltestandroid.model;

/**
 * Created by alejandrocordonurena on 11/11/2017.
 */


public class Account {

    private int id ;
    private String accountBalanceInCents     ="";
    private String accountCurrency           ="";
    private String accountId                 ="";
    private String accountName               ="";
    private String accountNumber             ="";
    private String accountType               ="";
    private String alias                     ="";
    private String iban                      ="";
    private String isVisible                 ="";
    private String linkedAccountId           ="";
    private String productName               ="";
    private String productType               ="";
    private String savingsTargetReached      ="";
    private String targetAmountInCents       ="";


    public Account() {

    }

    public Account(int id ,String accountBalanceInCents, String accountCurrency, String accountId, String accountName, String accountNumber, String accountType, String alias, String iban, String isVisible, String linkedAccountId, String productName, String productType, String savingsTargetReached, String targetAmountInCents) {
        this.id = id;
        this.accountBalanceInCents = accountBalanceInCents;
        this.accountCurrency = accountCurrency;
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.alias = alias;
        this.iban = iban;
        this.isVisible = isVisible;
        this.linkedAccountId = linkedAccountId;
        this.productName = productName;
        this.productType = productType;
        this.savingsTargetReached = savingsTargetReached;
        this.targetAmountInCents = targetAmountInCents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountBalanceInCents() {
        return accountBalanceInCents;
    }

    public void setAccountBalanceInCents(String accountBalanceInCents) {
        this.accountBalanceInCents = accountBalanceInCents;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    public String getLinkedAccountId() {
        return linkedAccountId;
    }

    public void setLinkedAccountId(String linkedAccountId) {
        this.linkedAccountId = linkedAccountId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSavingsTargetReached() {
        return savingsTargetReached;
    }

    public void setSavingsTargetReached(String savingsTargetReached) {
        this.savingsTargetReached = savingsTargetReached;
    }

    public String getTargetAmountInCents() {
        return targetAmountInCents;
    }

    public void setTargetAmountInCents(String targetAmountInCents) {
        this.targetAmountInCents = targetAmountInCents;
    }
}
