import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class CurrencyTest {

    Currency oneRupee = new Currency("Rupees", 78.84);
    Currency oneDollar = new Currency("Dollars", 1);

    @Test
    public void testDoesNotThrowExceptionForValidCurrency() {
        assertDoesNotThrow(() -> new Currency("Dollars", 3));
    }

//    @Test
//    public void testThrowsExceptionForZeroValuedCurrency() {
//        assertThrows(IllegalArgumentException.class, () -> new Currency("Dollars", 0));
//    }

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
        assertEquals(true, oneRupee.checkIfOnedollarEquals78_84Rupees(oneDollar, oneRupee));
    }


    @Test
    public void getEquivalentRupeesForGivenDollars() {
        double expectedValue = 78.84;

        double actualValue = oneDollar.convertToEquivalentRupeeValue();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getEquivalentDollarsForGivenRupee() {

        double expectedValue = 1;

        double actualValue = oneRupee.convertToEquivalentRupeeValue();
        assertEquals(expectedValue, actualValue);
    }


}