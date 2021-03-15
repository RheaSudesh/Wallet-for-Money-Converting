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

    @Test
    public void withdrawCurrencyAsRupees() {
        double withdrawRupees = 30;
        String currencyType = "Rupees";
        double expectedValue = 90;
        wallet.depositCurrency(currencyType, 120);

        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawRupees);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void withdrawCurrencyAsDollars() {
        double withdrawDollars = 3;
        String currencyType = "dollars";
        double expectedValue = 1;
        wallet.depositCurrency(currencyType, 4);

        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawDollars);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void withdrawCurrencyAsDollarsWhenInsuffientAmountOfDollars() {
        double withdrawDollars = 5;
        String currencyType = "dollars";
        double expectedValue = 0;
        wallet.depositCurrency("Rupees",78.84);
        wallet.depositCurrency("Dollars", 4);

        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawDollars);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void withdrawCurrencyAsRupeesWhenInsuffientAmountOfRupees() {
        double withdrawRupees = 78.84*2;
        String currencyType = "rupees";
        double expectedValue = 0;
        wallet.depositCurrency("Rupees",78.84);
        wallet.depositCurrency("Dollars", 1);

        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawRupees);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void withdrawCurrencyAsNegativeValuedCurrency() {
        double currencyValue = -12;
        String currencyType = "Rupees";

        assertThrows(ArithmeticException.class, () -> wallet.withdrawCurrency(currencyType, currencyValue));
    }

    @Test
    public void withdrawCurrencyAsZeroValuedCurrency() {
        double currencyValue = 0;
        String currencyType = "Rupees";

        assertThrows(ArithmeticException.class, () -> wallet.withdrawCurrency(currencyType, currencyValue));
    }

    @Test
    public void withdrawCurrencyMoreThanBalance(){
        double withdrawRupees = 50;
        String currencyType = "rupees";

        wallet.depositCurrency("Rupees",20);

        assertThrows(ArithmeticException.class, () -> wallet.withdrawCurrency(currencyType, withdrawRupees));
    }
}