import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CurrencyTest {

    Currency Rupees = new Currency(CurrencyType.RUPEES, 74.85);
    Currency Dollars = new Currency(CurrencyType.DOLLARS, 1);


    @Test
    public void testThrowsExceptionForNegativeValuedCurrency() {
        assertThrows(IllegalArgumentException.class, () -> new Currency(CurrencyType.DOLLARS, -2));
    }

    @Test
    public void testDoesNotThrowExceptionForValidCurrency() {
        assertDoesNotThrow(() -> new Currency(CurrencyType.DOLLARS, 3));
    }

    @Test
    public void testOneDollarEquivalentInRupees() {
        assertTrue( Currency.checkIfDollarsEquals78_84Rupees(Dollars, Rupees) );
    }

    @Test
    public void getEquivalentRupeesForGivenDollars() {
        double actualValue = Dollars.convertTo( CurrencyType.RUPEES.getCurrencyName());
        double expectedValue = 74.85;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getEquivalentDollarsForGivenRupee() {
        double actualValue = Rupees.convertTo( CurrencyType.DOLLARS.getCurrencyName());
        double expectedValue = 1;

        assertEquals(expectedValue, actualValue);
    }

}