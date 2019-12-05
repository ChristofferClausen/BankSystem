import java.util.UUID;

public class Account {
    private static Account  account = null;

    private int id;
    private double amount = 0;
    private Person person;
    private Bank bank;

    private Account() {
    }

    public Account(Person p, Bank b) {
        this.person = p;
        this.bank = b;
        //assignId();
    }

    public Account(int id, double amount, Person person, Bank bank) {
        this.id = id;
        this.amount = amount;
        this.person = person;
        this.bank = bank;
    }

    public static Account getInstance(){
        if (account == null)
        {
            account = new Account();
        }
        return account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId(){
        return id;
    }

    public double getBalance() {
        return amount;
    }

    public void addAmount(double a) {
        amount = amount + a;
    }

    public void removeAmount(double a) {
        amount = amount - a;
    }

    public Person getPerson() {
        return person;
    }

    public Bank getBank() {
        return bank;
    }

    public double getAmount() {
        return amount;
    }
}
