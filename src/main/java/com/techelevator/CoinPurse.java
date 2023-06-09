package com.techelevator;

import java.util.Map;

public class CoinPurse {

    private int pennyBalance;

    public CoinPurse() {
        this.pennyBalance = 0;
    }

    public void deposit(int amount) {
        // convert amount to pennies and add to balance
        pennyBalance += amount * 100d;
    }

    public void deduct(int amount) {
        // convert to pennies and subtract from balance
        pennyBalance -= amount;
    }

    public int getBalance() {
        // return current balance
        return this.pennyBalance;
    }

    public String getBalanceUser() {
        double dollarBalance = pennyBalance / 100.00;
        return String.format("%.2f", dollarBalance);
    }

    public Map<String, Integer> returnChange() {
        // calculate # of quarters, dimes, nickels, pennies
        // reset balance
        // return a Map where <String, Integer> = <Coin Type, Quantity>
        return null;
    }

}
