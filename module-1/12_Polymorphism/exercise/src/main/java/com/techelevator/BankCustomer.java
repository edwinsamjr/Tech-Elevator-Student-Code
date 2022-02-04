package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import static com.techelevator.BankAccount.printHelloWorld;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public BankCustomer() {

    }

    public BankCustomer(String name, String address, String phoneNumber, List<Accountable> accounts) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] accountList = new Accountable[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            accountList[i] = accounts.get(i);
        }

        return accountList;

    }

    public void addAccount(Accountable newAccount) {
            accounts.add(newAccount);
    }

    public boolean isVip(){
        int totalBalance = 0;
        for (Accountable account : accounts) {
            totalBalance += account.getBalance();
        }

        if (totalBalance >= 25000) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        printHelloWorld();
    }

}
