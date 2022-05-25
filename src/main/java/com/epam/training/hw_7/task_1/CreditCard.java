package com.epam.training.hw_7.task_1;

public class CreditCard extends Card {

    public CreditCard(String cardHolderName, double cardBalance) {
        super(cardHolderName, cardBalance);
    }

    public CreditCard(String cardHolderName) {
        super(cardHolderName);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public double replenishTheBalance(double replenishValue) {
        return super.replenishTheBalance(replenishValue);
    }

    @Override
    public double increaseTheBalance(double increaseValue) {
        return super.increaseTheBalance(increaseValue);
    }

    @Override
    public double withdrawBalanceAtTheEuroRate(double exchangeRate) {
        return super.withdrawBalanceAtTheEuroRate(exchangeRate);
    }
}
