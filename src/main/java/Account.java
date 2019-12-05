import java.util.UUID;

public class Account {

    private UUID id;
    private double amount;
    private Person person;
    private Bank bank;

    public Account(double a, Person p, Bank b) {
        this.amount = a;
        this.person = p;
        this.bank = b;
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

    public Person getPerson() {
        return person;
    }

    public Bank getBank() {
        return bank;
    }

}
