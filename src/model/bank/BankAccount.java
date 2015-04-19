package model.bank;

public class BankAccount {
    private int accountBalance;

    public BankAccount(int initialAmount) {
        accountBalance = initialAmount;
    }

    public void deposit(int amount) {
        accountBalance += amount;
    }

    public void withdraw(int amount) {
        if(tranasctionPossible(amount)) {
            applyTransaction(amount);
        }
    }

    public boolean tranasctionPossible(int amount) {
        int postBalance = accountBalance - amount;
        return postBalance > 0;
    }

    public void applyTransaction(int amount) {
        accountBalance -= amount;
    }

    public int getAccountBalance() {
        return accountBalance;
    }
}
