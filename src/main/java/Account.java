import java.util.UUID;

public class Account {

    private UUID id;
    private double amount = 0;
    private Person person;
    private Bank bank;

    public Account(Person p, Bank b) {
        this.person = p;
        this.bank = b;
        assignId();
    }

    private void assignId() {
        id = UUID.randomUUID();
    }

    public UUID getId(){
        return id;
    }

    public double getAmount() {
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

}
