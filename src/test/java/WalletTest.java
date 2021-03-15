import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WalletTest {

    Wallet wallet = new Wallet();

    @Test
    public void testDepositCurrencyAsRupees() {
        double currencyValue = 120;
        String currencyType = "Rupees";

        double expectedValue = 120;
        double actualValue = (double) wallet.depositCurrency(currencyType, currencyValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testDepositCurrencyAsDollars() {
        double currencyValue = 3;
        String currencyType = "Dollars";

        double expectedValue = 3;
        double actualValue = (double) wallet.depositCurrency(currencyType, currencyValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testDepositCurrencyAsZeroValuedCurrency() {
        double currencyValue = 0;
        String currencyType = "Rupees";

        assertThrows(IllegalArgumentException.class, () -> wallet.depositCurrency(currencyType, currencyValue));
    }

    @Test
    public void testDepositCurrencyAsNegativeValuedCurrency() {
        double currencyValue = -12;
        String currencyType = "Rupees";

        assertThrows(IllegalArgumentException.class, () -> wallet.depositCurrency(currencyType, currencyValue));
    }

    @Test
    public void testWithdrawCurrencyAsRupees() {
        double withdrawRupees = 30;
        String currencyType = "Rupees";

        wallet.depositCurrency(currencyType, 120);

        double expectedValue = 90;
        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawRupees);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWithdrawCurrencyAsDollars() {
        double withdrawDollars = 3;
        String currencyType = "dollars";

        wallet.depositCurrency(currencyType, 4);

        double expectedValue = 1;
        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawDollars);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWithdrawCurrencyAsDollarsWhenInsuffientAmountOfDollars() {
        double withdrawDollars = 5;
        String currencyType = "dollars";

        wallet.depositCurrency("Rupees", 78.84);
        wallet.depositCurrency("Dollars", 4);

        double expectedValue = 0;
        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawDollars);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWithdrawCurrencyAsRupeesWhenInsuffientAmountOfRupees() {
        double withdrawRupees = 78.84 * 2;
        String currencyType = "rupees";

        wallet.depositCurrency("Rupees", 78.84);
        wallet.depositCurrency("Dollars", 1);

        double expectedValue = 0;
        double actualValue = (double) wallet.withdrawCurrency(currencyType, withdrawRupees);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWithdrawCurrencyAsNegativeValuedCurrency() {
        double currencyValue = -12;
        String currencyType = "Rupees";

        assertThrows(ArithmeticException.class, () -> wallet.withdrawCurrency(currencyType, currencyValue));
    }

    @Test
    public void testWithdrawCurrencyAsZeroValuedCurrency() {
        double currencyValue = 0;
        String currencyType = "Rupees";

        assertThrows(ArithmeticException.class, () -> wallet.withdrawCurrency(currencyType, currencyValue));
    }

    @Test
    public void testWithdrawCurrencyMoreThanBalance() {
        double withdrawRupees = 50;
        String currencyType = "rupees";

        wallet.depositCurrency("Rupees", 20);

        assertThrows(ArithmeticException.class, () -> wallet.withdrawCurrency(currencyType, withdrawRupees));
    }

    @Test
    public void testCheckBalanceAsDollars() {
        String currencyType = "doLLars";

        wallet.depositCurrency("Rupees", 78.84);
        wallet.depositCurrency("Dollars", 1);

        double expectedValue = 2;
        double actualValue = (double) wallet.moneyInWallet(currencyType);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testCheckBalanceAsRupees() {
        String currencyType = "ruPees";

        wallet.depositCurrency("Rupees", 78.84);
        wallet.depositCurrency("Dollars", 1);

        double expectedValue = 157.68;
        double actualValue = (double) wallet.moneyInWallet(currencyType);

        assertEquals(expectedValue, actualValue);
    }
}