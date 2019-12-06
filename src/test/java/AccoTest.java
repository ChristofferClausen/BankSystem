import bank.BankName;
import human.Person;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccoTest {

    Person person = new Person("Firstname", "Lastname", 25);
    BankName bankName = new BankName("test");

    Acco acco = new Acco(person, bankName);

    @Order(1)
    @Test
    public void ConstructorTest() {
    }

    @Order(2)
    @Test
    public void idTest() {
        Assertions.assertNotNull(acco.getId());
    }

    @Order(3)
    @Test
    public void getAmountTest() {
        Assertions.assertEquals(0, acco.getAmount());
    }

    @Order(4)
    @Test
    public void addAmountTest() {
        acco.addAmount(100);
        Assertions.assertEquals(100, acco.getAmount());

    }

    @Order(5)
    @Test
    public void removeAmountTest() {
        acco.addAmount(100);
        acco.removeAmount(50);
        Assertions.assertEquals(50, acco.getAmount());
    }

    @Order(6)
    @Test
    public void getPersonTest() {
        Assertions.assertEquals(person, acco.getPerson());
    }

    @Order(7)
    @Test
    public void  getBankTest() {
        Assertions.assertEquals(bankName, acco.getBankName());
    }
}
