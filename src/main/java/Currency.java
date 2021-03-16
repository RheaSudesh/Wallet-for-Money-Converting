public class Currency {
    CurrencyType name;
    double value;
    static double currencyConversionRate = 74.85;


    Currency(CurrencyType currencyName, double currencyValue) {
        if (currencyValue < 0)
            throw new IllegalArgumentException("Currency values do not support Negative values");
        else {
            this.name = currencyName;
            this.value = currencyValue;
        }
    }

    public static boolean checkIfDollarsEquals78_84Rupees(Currency Dollars, Currency Rupees) {
        return Math.floor(Rupees.value / currencyConversionRate) == Dollars.value;
    }

    public double convertTo(String targetCurrencyType) {
        if (this.name.getCurrencyName().equalsIgnoreCase("Dollars") && targetCurrencyType.equalsIgnoreCase("Rupees"))
                return this.value * currencyConversionRate;
        else if (this.name.getCurrencyName().equalsIgnoreCase("Rupees") && targetCurrencyType.equalsIgnoreCase("Dollars"))
            return this.value / currencyConversionRate;
        else
            return value;
    }



}
