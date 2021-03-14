import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WalletTest {

    Wallet wallet = new Wallet();

    @Test
    public void checkIfOneDollarEqualsEquivalentRupees() {
        double currencyValueInDollars = 1;
        String currencyType = "Dollars";
        double expectedValue=78.84;

        double actualValue = wallet.convertToEquivalentCurrencyValue( currencyType, currencyValueInDollars);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void checkIfOneRupeeEqualsEquivalentDollars() {
        double currencyValueInRupees = 78.84;
        String currencyType = "Rupees";
        double expectedValue=1;

        double actualValue = wallet.convertToEquivalentCurrencyValue( currencyType, currencyValueInRupees);
        assertEquals(expectedValue,actualValue);
    }
}