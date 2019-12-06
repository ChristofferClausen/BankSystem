import bank.BankName;
import org.junit.jupiter.api.Test;

public class AppControllerTest {
    @Test
    void createAccountTest(){
        AppController appController = new AppController();
        appController.createNewAccount();
        Model model = new Model();
        for (BankName b : model.accountList)
        {
            System.out.println(b);
        }
    }
}
