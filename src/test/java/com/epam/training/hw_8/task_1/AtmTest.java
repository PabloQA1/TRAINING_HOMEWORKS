package com.epam.training.hw_8.task_1;

import com.epam.training.hw_7.task_1.Atm;
import com.epam.training.hw_7.task_1.CreditCard;
import com.epam.training.hw_7.task_1.DebitCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

    Atm atm = new Atm();
    CreditCard creditCard = new CreditCard("John Smith", 100);
    DebitCard debitCard = new DebitCard("Sam Smith", 100);

    @Test
    public void testAtmWithdrawFunctionWithCreditCard() {
        double value = atm.withdrawTheAmountFromTheCard(creditCard,50);
        Assert.assertEquals(50,value,0);
    }

    @Test
    public void testAtmIncreaseFunctionWithCreditCard() {
        double value = atm.increaseTheAmountToTheCard(creditCard,50);
        Assert.assertEquals(150,value,0);
    }

    @Test
    public void testAtmWithdrawFunctionWithDebitCard() {
        double value = atm.withdrawTheAmountFromTheCard(debitCard,100);
        Assert.assertEquals(0,value,0);
    }

    @Test
    public void testAtmIncreaseFunctionWithDebitCard() {
        double value = atm.increaseTheAmountToTheCard(debitCard,50);
        Assert.assertEquals(150,value,0);
    }
}