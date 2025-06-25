package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

// nested test cases demo

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Negative initial balance");
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}


public class BankTests_Nestes_Test_cases {
	BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0);
    }

    @Nested
    class DepositTests {

        @Test
        void shouldIncreaseBalanceOnDeposit() {
            account.deposit(500);
            assertEquals(1500.0, account.getBalance());
        }

        @Test
        void shouldThrowExceptionOnNegativeDeposit() {
            assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        }
    }

    @Nested
    class WithdrawalTests {

        @Test
        void shouldDecreaseBalanceOnWithdraw() {
            account.withdraw(300);
            assertEquals(700.0, account.getBalance());
        }

        @Test
        void shouldThrowExceptionWhenWithdrawMoreThanBalance() {
            assertThrows(IllegalArgumentException.class, () -> account.withdraw(1200));
        }
    }

    @Nested
    class InitializationTests {

        @Test
        void shouldThrowExceptionOnNegativeInitialBalance() {
            assertThrows(IllegalArgumentException.class, () -> new BankAccount(-500));
        }
    }

}
