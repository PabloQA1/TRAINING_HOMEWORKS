package com.epam.training.hw_7.task_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

    Card card;

    @Before
    public void initClass() {
        card = new Card("John Smith", 999.99);
    }

    @Test
    public void testGetBalance() {
        Assert.assertEquals(999.99, card.getBalance(), 0);
    }

    @Test
    public void testReplenishTheBalance() {
        Assert.assertEquals(888.88, card.replenishTheBalance(111.11), 0);
    }

    @Test
    public void testIncreaseTheBalance() {
        Assert.assertEquals(1000, card.increaseTheBalance(0.01), 0);
    }

    @Test
    public void testWithdrawBalanceAtTheEuroRate() {
        Assert.assertEquals(899.991, card.withdrawBalanceAtTheEuroRate(0.9), 0);
    }
}
