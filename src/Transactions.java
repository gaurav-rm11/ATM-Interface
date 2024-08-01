public interface Transactions {
    abstract void withdraw(int amount);

    abstract void deposit(int amount);

    abstract void transfer(int amount, Account ac);

    abstract void transactionHistory();
}
