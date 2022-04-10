package com.example.natwest.natwest.model;

import javax.persistence.*;

@Entity
@Table(name="accountDetails")
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                '}';
    }

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="type")
    private String type;

    @Column(name="amount")
    private String amount;

    @Column(name="currency")
    private String currency;

    @Column(name="account_from")
    private String fromAccount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
}
