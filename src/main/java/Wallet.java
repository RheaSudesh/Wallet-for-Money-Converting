public class Wallet {

    Currency oneRupee = new Currency("Rupees", 0);
    Currency oneDollar = new Currency("Dollars", 0);

    final double dollarToRupeeConverstionRate = 78.84;

    public double getCurrencyvalue(String name) {
        if (name.equalsIgnoreCase(oneRupee.name))
            return oneRupee.value;
        else
            return oneDollar.value;
    }

    public double depositCurrency(String currencyType, double currencyValue) {
        if (currencyValue <= 0)
            throw new IllegalArgumentException("Currency values do not support Zero or Negative values");
        else {
            if (currencyType.equalsIgnoreCase(oneRupee.name))
                oneRupee.value += currencyValue;
            else if (currencyType.equalsIgnoreCase(oneDollar.name))
                oneDollar.value += currencyValue;
        }
        return getCurrencyvalue(currencyType);
    }

}
