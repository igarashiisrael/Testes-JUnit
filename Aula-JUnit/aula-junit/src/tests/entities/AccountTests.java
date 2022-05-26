package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceAndDiscountFeelWhenPositiveAmount(){

        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

        acc.deposit(amount);
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }
    @Test
    public void depositShouldDoNothingWhenNegativeAmount(){

        double expectValue = 100.0;
        Account acc = AccountFactory.createAccount(expectValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance(){

        double expectedValue = 0.0;
        double initialBalance = 800.00;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);

    }
}
