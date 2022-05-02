package com.epam.training.hw_7.task_1;

public class DebitCard extends Card {

    private static final String ERROR_MESSAGE = "The amount on the account is less than requested!";

    public DebitCard(String cardHolderName, double cardBalance) {
        super(cardHolderName, cardBalance);
    }

    public DebitCard(String cardHolderName) {
        super(cardHolderName);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public double replenishTheBalance(double replenishValue) {
        if (replenishValue > getBalance()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        } else {
            return super.replenishTheBalance(replenishValue);
        }
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
