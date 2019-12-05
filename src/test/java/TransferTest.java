import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransferTest {

    Person person = new Person("Firstname", "Lastname", 25);
    Bank bank = new Bank();
    Account account = new Account(person, bank);
    Account account2 = new Account(person, bank);
    Transfer transfer = new Transfer();

    @Order(1)
    @Test
    public void depositTest() {
        transfer.deposit(account, 100);
        Assertions.assertEquals(100, account.getAmount());
    }

    @Order(2)
    @Test
    public void withdrawTest() {
        transfer.deposit(account, 100);
        transfer.withdraw(account, 100);
        Assertions.assertEquals(0, account.getAmount());
    }

    @Order(3)
    @Test
    public void transferTest() {
        transfer.deposit(account, 100);
        transfer.transfer(account, account2, 50);
        Assertions.assertEquals(50, account.getAmount());
        Assertions.assertEquals(50, account2.getAmount());
    }
}
