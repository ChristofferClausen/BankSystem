import java.util.ArrayList;

public class AccountingSystem {
    private ArrayList<Person> persons;

    public AccountingSystem() {
        this.persons = new ArrayList<>();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void createBank(String s) {
        //Bank b = new Bank(s);
    }

    public void createPerson(String fn, String ln, int age) {
        Person person = new Person(fn, ln, age);
        persons.add(person);
    }

    public void createAccount(double saldo, Person p, Bank b) {
        //Account account = new Account(saldo, p, b);
    }
}