import bank.BankName;
import human.Person;

import java.util.ArrayList;
import java.util.List;

public class AccountingSystem {

    public BankName createBank(String bankName) {
        return new BankName(bankName);
    }
    public Person createPerson(String fn, String ln, int age) {
        return new Person(fn,ln,age);
    }
    public List createAccount(String bankName, int accountId, float saldo, Person person) {
        List<BankName> accountList = new ArrayList<>();
        accountList.add(new BankName(bankName, BankName.getInstance().accountId(), saldo, person));
        return accountList;
    }
}