import src.main.java.BankName;
import src.main.java.Bank;

public class AccountingSystem {

    public void createBank(String s) {
        Bank b = new Bank(s);
    }

    public void createPerson(String fn, String ln, int age) {
        Person person = new Person(fn, ln, age);
    }

    public void createAccount(double saldo, Person p, Bank b) {
        Account account = new Account(saldo, p, b);
    }
}