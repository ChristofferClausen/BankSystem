import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankNameTest {

    BankName bank;

    @Test
    @DisplayName("Getter Test")
    void getName() {
        bank= new BankName("Handelsbanken");
        assertAll(
                ()-> assertEquals("Handelsbanken", bank.getName()),
                ()-> assertNotNull(bank));

    }

    @Test
    @DisplayName("Setter Test")
    void setName() {
        bank= new BankName("Handelsbanken");
        bank.setName("Swedebank");
        assertEquals("Swedebank", bank.getName());
    }
}