import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank;

    @Test
    @DisplayName("Getter Test")
    void getName() {
        bank= new Bank("Handelsbanken");
        assertAll(
                ()-> assertEquals("Handelsbanken", bank.getName()),
                ()-> assertNotNull(bank));

    }

    @Test
    @DisplayName("Setter Test")
    void setName() {
        bank= new Bank("Handelsbanken");
        bank.setName("Swedebank");
        assertEquals("Swedebank", bank.getName());
    }
}