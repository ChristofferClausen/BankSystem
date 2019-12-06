import bank.BankName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class AppControllerTest {

    @Test
    void createAccountTest()throws NoSuchMethodException, InvocationTargetException, IllegalAccessException  {
        AppController appController = new AppController();
        Method method = AppController.class.getDeclaredMethod("createNewAccount");
        method.setAccessible(true);
        method.invoke(appController);
        Model model = new Model();
        for (BankName b : BankName.getInstance().accountList)
        {
            System.out.println(b);
        }
    }
}
