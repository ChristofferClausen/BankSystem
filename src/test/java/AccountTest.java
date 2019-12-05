import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountTest {

    Person person = new Person("Firstname", "Lastname", 25);
    Bank bank = new Bank("test");
    Account account = new Account(person, bank);

    @Order(1)
    @Test
    public void ConstructorTest() {
    }

    @Order(2)
    @Test
    public void idTest() {
        Assertions.assertNotNull(account.getId());
    }

    @Order(3)
    @Test
    public void getAmountTest() {
        Assertions.assertEquals(0,account.getAmount());
    }

    @Order(4)
    @Test
    public void addAmountTest() {
        account.addAmount(100);
        Assertions.assertEquals(100, account.getAmount());

    }

    @Order(5)
    @Test
    public void removeAmountTest() {
        account.addAmount(100);
        account.removeAmount(50);
        Assertions.assertEquals(50, account.getAmount());
    }

    @Order(6)
    @Test
    public void getPersonTest() {
        Assertions.assertEquals(person, account.getPerson());
    }

    @Order(7)
    @Test
    public void  getBankTest() {
//        Assertions.assertEquals(bank, account.getBank());
    }
}
