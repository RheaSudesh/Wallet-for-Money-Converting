import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WalletTest {

    Wallet wallet = new Wallet();

    @Test
    public void testDepositCurrencyAsRupees() {
        Currency amountToDepositAsRupees = new Currency( CurrencyType.RUPEES , 120);

        double expectedValue = 120;
        double actualValue = (double) wallet.depositCurrency(amountToDepositAsRupees);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testDepositCurrencyAsDollars() {
        Currency  amountToDepositAsDollars= new Currency( CurrencyType.DOLLARS , 3);

        double expectedValue = 3;
        double actualValue = (double) wallet.depositCurrency(amountToDepositAsDollars);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testThrowsExceptionDepositZeroValuedCurrency() {
        Currency amountToDepositAsRupees = new Currency( CurrencyType.RUPEES , 0);

        assertThrows(IllegalArgumentException.class, () -> wallet.depositCurrency(amountToDepositAsRupees));
    }

    @Test
    public void testWithdrawCurrencyAsRupees() {
        Currency amountToDepositAsRupees = new Currency( CurrencyType.RUPEES , 120);
        Currency amountToWithdrawAsRupees  = new Currency( CurrencyType.RUPEES , 30);

        wallet.depositCurrency(amountToDepositAsRupees);

        double expectedValue = 90;
        double actualValue = (double) wallet.withdrawCurrency(amountToWithdrawAsRupees);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWithdrawCurrencyAsDollars() {
        Currency amountToDepositAsDollars = new Currency( CurrencyType.DOLLARS , 4);
        Currency amountToWithdrawAsDollars  = new Currency( CurrencyType.DOLLARS , 3);

        wallet.depositCurrency(amountToDepositAsDollars);

        double expectedValue = 1;
        double actualValue = (double) wallet.withdrawCurrency(amountToWithdrawAsDollars);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWithdrawCurrencyAsDollarsWhenInsufficientAmountOfDollars() {
        Currency amountToDepositAsRupees = new Currency( CurrencyType.RUPEES , 74.85);
        Currency amountToDepositAsDollars = new Currency( CurrencyType.DOLLARS , 4);
        Currency amountToWithdrawAsDollars  = new Currency( CurrencyType.DOLLARS , 5);

        wallet.depositCurrency(amountToDepositAsRupees);
        wallet.depositCurrency(amountToDepositAsDollars);

        double expectedValue = 0;
        double actualValue = (double) wallet.withdrawCurrency(amountToWithdrawAsDollars);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testWithdrawCurrencyAsRupeesWhenInsufficientAmountOfRupees() {
        Currency amountToDepositAsRupees = new Currency( CurrencyType.RUPEES , 74.85);
        Currency amountToDepositAsDollars = new Currency( CurrencyType.DOLLARS , 1);
        Currency amountToWithdrawAsRupees  = new Currency( CurrencyType.RUPEES , 149.7);

        wallet.depositCurrency(amountToDepositAsRupees);
        wallet.depositCurrency(amountToDepositAsDollars);

        double expectedValue = 0;
        double actualValue = (double) wallet.withdrawCurrency(amountToWithdrawAsRupees);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testThrowsExceptionWithdrawZeroValuedCurrency() {
        Currency amountWithdrawn  = new Currency( CurrencyType.RUPEES , 0);

        assertThrows(IllegalArgumentException.class, () -> wallet.withdrawCurrency(amountWithdrawn));
    }

    @Test
    public void testThrowsExceptionWithdrawMoreThanBalance() {

        Currency amountToDepositAsRupees = new Currency( CurrencyType.RUPEES , 20);
        Currency amountToWithdrawAsRupees  = new Currency( CurrencyType.RUPEES , 50);

        wallet.depositCurrency(amountToDepositAsRupees);

        assertThrows(ArithmeticException.class, () -> wallet.withdrawCurrency(amountToWithdrawAsRupees));
    }

    @Test
    public void testCheckBalanceAsDollars() {
        Currency amountToDepositAsRupees = new Currency( CurrencyType.RUPEES , 74.85);
        Currency amountToDepositAsDollars = new Currency( CurrencyType.DOLLARS , 1);

        wallet.depositCurrency(amountToDepositAsRupees);
        wallet.depositCurrency(amountToDepositAsDollars);

        double expectedValue = 2;
        double actualValue = (double) wallet.checkBalanceForCurrencyType(CurrencyType.DOLLARS);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testCheckBalanceAsRupees() {
        Currency amountToDepositAsRupees = new Currency(CurrencyType.RUPEES, 74.85);
        Currency amountToDepositAsDollars = new Currency(CurrencyType.DOLLARS, 1);

        wallet.depositCurrency(amountToDepositAsRupees);
        wallet.depositCurrency(amountToDepositAsDollars);

        double expectedValue = 149.7;
        double actualValue = (double) wallet.checkBalanceForCurrencyType(CurrencyType.RUPEES);

        assertEquals(expectedValue, actualValue);
    }
}