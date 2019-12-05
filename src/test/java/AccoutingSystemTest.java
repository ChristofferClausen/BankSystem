import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccoutingSystemTest {

    private AccountingSystem accountingSystem;

    @Test
    public void constructorTest() {
        AccountingSystem accountingSystem = new AccountingSystem();
    }

    @Test
    public void createPersonTest() {
        AccountingSystem accountingSystem = new AccountingSystem();

        accountingSystem.createPerson("John", "Doe", 55);

        Assertions.assertEquals(1, accountingSystem.getPersons().size());
        Assertions.assertEquals(1, accountingSystem.getPersons().get(0).getId());
        Assertions.assertEquals("John", accountingSystem.getPersons().get(0).getFirstName());
        Assertions.assertEquals("Doe", accountingSystem.getPersons().get(0).getLastName());
        Assertions.assertEquals(55, accountingSystem.getPersons().get(0).getAge());
    }

    @Test
    public void createBankTest() {
    }

    @Test
    public void createAccountTest() {
    }

}