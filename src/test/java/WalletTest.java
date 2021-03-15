import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WalletTest {

    Wallet wallet = new Wallet();

    @Test
    public void depositCurrencyAsRupees() {
        double currencyValue = 120;
        String currencyType = "Rupees";
        double expectedValue = 120;

        double actualValue = (double) wallet.depositCurrency(currencyType, currencyValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void depositCurrencyAsDollars() {
        double currencyValue = 3;
        String currencyType = "Dollars";
        double expectedValue = 3;

        double actualValue = (double) wallet.depositCurrency(currencyType, currencyValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void depositCurrencyAsZeroValuedCurrency() {
        double currencyValue = 0;
        String currencyType = "Rupees";

        assertThrows(IllegalArgumentException.class, () -> wallet.depositCurrency(currencyType, currencyValue));
    }

    @Test
    public void depositCurrencyAsNegativeValuedCurrency() {
        double currencyValue = -12;
        String currencyType = "Rupees";

        assertThrows(IllegalArgumentException.class, () -> wallet.depositCurrency(currencyType, currencyValue));
    }


}