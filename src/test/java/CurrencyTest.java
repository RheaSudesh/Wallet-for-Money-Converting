import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CurrencyTest {

    Currency Rupees = new Currency("Rupees", 78.84);
    Currency Dollars = new Currency("Dollars", 1);

    @Test
    public void testDoesNotThrowExceptionForValidCurrency() {
        assertDoesNotThrow(() -> new Currency("Dollars", 3));
    }

    @Test
    public void testThrowsExceptionForNegativeValuedCurrency() {
        assertThrows(IllegalArgumentException.class, () -> new Currency("Dollars", -2));
    }

    @Test
    public void testThrowsExceptionForInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Currency("Paisa", 10));
    }

    @Test
    public void testDollarEquivalentToRupees() {
        assertEquals(true, Rupees.checkIfDollarsEquals78_84Rupees(Dollars, Rupees));
    }

    @Test
    public void getEquivalentRupeesForGivenDollars() {
        String currencyType = "Rupees";

        double expectedValue = 78.84;
        double actualValue = Dollars.convertToEquivalentCurrencyValue(currencyType);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getEquivalentDollarsForGivenRupee() {
        String currencyType = "Dollars";

        double expectedValue = 1;
        double actualValue = Rupees.convertToEquivalentCurrencyValue(currencyType);

        assertEquals(expectedValue, actualValue);
    }

}