import bank.BankName;
import human.Person;

public class Acco {

    private int id;
    private double amount = 0;
    private Person person;
    private BankName bankName;



    public Acco(Person p, BankName b) {
        this.person = p;
        this.bankName = b;
        //assignId();
    }

    public Acco(int id, double amount, Person person, BankName bankName) {
        this.id = id;
        this.amount = amount;
        this.person = person;
        this.bankName = bankName;
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

    public BankName getBankName() {
        return bankName;
    }

    public double getAmount() {
        return amount;
    }
}
