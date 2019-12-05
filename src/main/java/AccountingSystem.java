import java.util.ArrayList;

public class AccountingSystem {
    private ArrayList<Person> persons;

    private int nextPersonId;

    public AccountingSystem() {
        this.persons = new ArrayList<>();
        nextPersonId = 1;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void createBank(String s) {
        //Bank b = new Bank(s);
    }

    public void createPerson(String fn, String ln, int age) {
        Person person = new Person(nextPersonId++, fn, ln, age);
        persons.add(person);
    }

    public void createAccount(double saldo, Person p, Bank b) {
        //Account account = new Account(saldo, p, b);
    }
}