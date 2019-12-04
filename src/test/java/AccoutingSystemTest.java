import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccoutingSystemTest {

    private AccountingSystem accountingSystem;

    @Test
    public void constructorTest() {
        AccountingSystem accountingSystem = new AccountingSystem();
    }

    @Test
    public void createPersonTest() {
    }

    @Test
    public void createBankTest() {
    }

    @Test
    public void createAccountTest() {
    }

}