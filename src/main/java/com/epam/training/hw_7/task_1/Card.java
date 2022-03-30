package com.epam.training.hw_7.task_1;

public class Card {

    private final String cardHolderName;
    private double cardBalance;

    public Card(String cardHolderName, double cardBalance) {
        this.cardHolderName = cardHolderName;
        this.cardBalance = cardBalance;
    }

    public Card(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public double getBalance() {
        return this.cardBalance;
    }

    public double replenishTheBalance(double replenishValue) {
        return this.cardBalance - replenishValue;
    }

    public double increaseTheBalance(double increaseValue) {
        return this.cardBalance + increaseValue;
    }

    public double withdrawBalanceAtTheEuroRate(double exchangeRate) {
        return this.cardBalance *exchangeRate;
    }
}

