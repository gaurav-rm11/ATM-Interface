import java.util.ArrayList;
import java.util.Calendar;

public class Account extends User implements Transactions {

    private int Balance;

    public void setBalance(int amount) {
        this.Balance = amount;
    }

    public int getBalance() {
        return this.Balance;
    }

    ArrayList<String> transaction_History = new ArrayList<>();

    public Account(String name, String id, int pin) {
        super(name, id, pin);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= this.Balance) {
            this.Balance -= amount;
            System.out.println("rupees " + amount + " has been withdrawn");
            Calendar calobj = Calendar.getInstance();
            transaction_History.add("Withdrawal of rupees " + amount + " " + calobj.getTime());
        } else {
            System.out.println("insufficient balance");
        }
    }

    @Override
    public void deposit(int amount) {
        this.Balance += amount;
        System.out.println("rupees " + amount + " has been added to your account");
        Calendar calobj = Calendar.getInstance();
        transaction_History.add("Deposit of rupees " + amount + " " + calobj.getTime());
    }

    @Override
    public void transfer(int amount, Account ac) {
        this.Balance -= amount;
        ac.Balance += amount;
        System.out.println(
                "Transfer of rupees " + amount + " is successful from your account to" + " to " + ac.getUserID());
        Calendar calobj = Calendar.getInstance();
        transaction_History.add("Transfer to " + ac.getUserName() + " of rupees " + amount + " " + calobj.getTime());
    }

    @Override
    public void transactionHistory() {
        int count = 1;
        for (int i = 0; i < transaction_History.size(); i++) {
            System.out.println(count + ". " + transaction_History.get(i));
            count++;
        }
    }
}
