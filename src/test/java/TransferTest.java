import bank.BankName;
import human.Person;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransferTest {




   /* human.Person person = new human.Person("Firstname", "Lastname", 25);
    bank.Bank bank = new bank.Bank("test");


    Account account = new Account(person, bank);
    Account account2 = new Account(person, bank);
    Transfer transfer = new Transfer();

    @Order(1)
    @Test
    public void depositTest() {
        transfer.deposit(account, 100);
        Assertions.assertEquals(100, account.getBalance());
    }

    @Order(2)
    @Test
    public void withdrawTest() {
        transfer.deposit(account, 100);
        transfer.withdraw(account, 100);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Order(3)
    @Test
    public void transferTest() {
        transfer.deposit(account, 100);
        transfer.transfer(account, account2, 50);
        Assertions.assertEquals(50, account.getBalance());
        Assertions.assertEquals(50, account2.getBalance());
    }*/
}
