public class Currency {
    String name;
    double value;
    static double currencyConvertionRate = 78.84;

    Currency(String currencyName, double currencyValue) {
        if (currencyValue < 0)
            throw new IllegalArgumentException("Currency values do not support Negative values");
        else if (!(currencyName.equalsIgnoreCase("Rupees") || currencyName.equalsIgnoreCase("Dollars")))
            throw new IllegalArgumentException("Currency can be of type Rupee or Dollar only");
        else
            {
            this.name = currencyName;
            this.value = currencyValue;
        }
    }

    public static boolean checkIfDollarsEquals78_84Rupees(Currency Dollars, Currency Rupees) {
        if (Dollars.name.equalsIgnoreCase("Dollars") && Rupees.name.equalsIgnoreCase("Rupees"))
            if (Math.floor(Rupees.value / currencyConvertionRate) == Dollars.value) {
                return true;
            }
        return false;
    }

    public double convertToEquivalentCurrencyValue(String targetCurrencyType) {
        if(this.name.equalsIgnoreCase( "Rupees" ) && targetCurrencyType.equalsIgnoreCase("Dollars"))
            return this.value / currencyConvertionRate;
        else if(this.name.equalsIgnoreCase( "Dollars" ) && targetCurrencyType.equalsIgnoreCase("Rupees"))
            return this.value * currencyConvertionRate;
        else
            return value;
    }


}
