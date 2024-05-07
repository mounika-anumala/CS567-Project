package com.example.project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankingSystemTest {

    private BankingSystem bankingSystem;

    @Before
    public void setUp() {
        bankingSystem = new BankingSystem();
        bankingSystem.createAccount("123456", 1000);
    }

    @Test
    public void testCreateAccount() {
        bankingSystem.createAccount("654321", 500);
        assertNotNull(bankingSystem.checkBalance("654321"));
    }

    @Test
    public void testDeposit() {
        bankingSystem.deposit("123456", 500);
        assertEquals(1500, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testWithdrawSufficientBalance() {
        bankingSystem.withdraw("123456", 500);
        assertEquals(500, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        bankingSystem.withdraw("123456", 2000);
        assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testTransfer() {
        bankingSystem.createAccount("654321", 500);
        bankingSystem.transfer("123456", "654321", 200);
        assertEquals(800, bankingSystem.checkBalance("123456"), 0);
        assertEquals(700, bankingSystem.checkBalance("654321"), 0);
    }

    @Test
    public void testCheckBalance() {
        assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testCreateDuplicateAccount() {
        bankingSystem.createAccount("123456", 500);
        assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testDepositNegativeAmount() {
        bankingSystem.deposit("123456", -200);
        assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testWithdrawZeroAmount() {
        bankingSystem.withdraw("123456", 0);
        assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        bankingSystem.withdraw("123456", -200);
        assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    }

    // @Test
    // public void testTransferInsufficientBalance() {
    //     bankingSystem.createAccount("654321", 500);
    //     bankingSystem.transfer("123456", "654321", 2000);
    //     assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    //     assertEquals(500, bankingSystem.checkBalance("654321"), 0);
    // }

    @Test
    public void testTransferBetweenSameAccount() {
        bankingSystem.transfer("123456", "123456", 500);
        assertEquals(1000, bankingSystem.checkBalance("123456"), 0);
    }

    @Test
    public void testCheckBalanceNonExistentAccount() {
        assertEquals(0, bankingSystem.checkBalance("654321"), 0);
    }

}
