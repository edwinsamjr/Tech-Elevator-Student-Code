package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }


    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance = super.balance - amountToWithdraw;
        int balanceAfterFee = super.balance - amountToWithdraw - 10;

        if (newBalance < 0 && newBalance > -100) {
            super.balance -= (amountToWithdraw + 10);
            return super.balance;
        } else if (newBalance < 0) {
            return super.balance;
        } else {
            super.balance -= amountToWithdraw;
            return super.balance;
        }

    }


}
