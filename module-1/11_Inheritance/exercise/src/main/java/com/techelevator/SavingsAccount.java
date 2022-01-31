package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance = super.balance - amountToWithdraw;

        if (newBalance < 2) {
            return super.balance;
        } else if (newBalance < 150) {
            super.balance -= (amountToWithdraw + 2);
            return super.balance;
        } else {
            super.balance -=amountToWithdraw;
            return super.balance;
        }
    }

}
