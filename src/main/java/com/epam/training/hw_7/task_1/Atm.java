package com.epam.training.hw_7.task_1;

public class Atm {


    public double withdrawTheAmountFromTheCard(Card card, double value) {
        return card.replenishTheBalance(value);
    }

    public  double increaseTheAmountToTheCard(Card card, double value) {
        return card.increaseTheBalance(value);
    }
}
