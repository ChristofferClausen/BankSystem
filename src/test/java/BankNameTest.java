import bank.BankName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BankNameTest {

    BankName bankName;

    @Test
    @DisplayName("Getter Test")
    void getName() {
        bankName = new BankName("Handelsbanken");
        assertAll(
                ()-> assertEquals("Handelsbanken", bankName.getName()),
                ()-> assertNotNull(bankName));

    }

    @Test
    @DisplayName("Setter Test")
    void setName() {
        bankName = new BankName("Handelsbanken");
        bankName.setName("Swedebank");
        assertEquals("Swedebank", bankName.getName());
    }
    @Test
    @DisplayName("check account ID")
    void checkIdTest(){
        BankName.getInstance().dataForTest();
        Assertions.assertTrue(BankName.getInstance().checkAccountId(1103), "True");
    }
    @Test
    void testTransfer(){
        BankName.getInstance().dataForTest();
        BankName.getInstance().transfer(1100, 1103, 10000);
        List<BankName> filterList = BankName.getInstance().accountList.stream()
                .filter(e -> e.getId() == 1100)
                .collect(Collectors.toList());
        int index = BankName.getInstance().accountList.indexOf(filterList.get(0));
        float amount = BankName.getInstance().accountList.get(index).getSaldo();
        List<BankName> filterList1 = BankName.getInstance().accountList.stream()
                .filter(e -> e.getId() == 1103)
                .collect(Collectors.toList());
        int index1 = BankName.getInstance().accountList.indexOf(filterList1.get(0));
        double amount1 = BankName.getInstance().accountList.get(index1).getSaldo();
        System.out.println("It was : 20000 kr and the Amount [FROM] after transfer : " +amount);
        System.out.println("It was : 40000 kr and the Amount [TO] after transfer : " +amount1);
        Assertions.assertEquals(50000,  amount1);
    }
}