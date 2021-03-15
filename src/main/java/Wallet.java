
public class Wallet {

    Currency Rupees = new Currency("Rupees", 0);
    Currency Dollars = new Currency("Dollars", 0);

    final double dollarRupeeConversationRate = 78.84;

    public double getCurrencyValue(String name) {
        if (name.equalsIgnoreCase(Rupees.name))
            return Rupees.value;
        else if(name.equalsIgnoreCase(Dollars.name))
            return Dollars.value;
        else
            return 0.0;
    }

    public double depositCurrency(String currencyType, double currencyValue) {
        if (currencyValue <= 0)
            throw new IllegalArgumentException("Currency values do not support Zero or Negative values");
        else {
            if (currencyType.equalsIgnoreCase(Rupees.name))
                Rupees.value += currencyValue;
            else if (currencyType.equalsIgnoreCase(Dollars.name))
                Dollars.value += currencyValue;
        }
        return getCurrencyValue(currencyType);
    }

    public double withdrawCurrency(String currencyType, double currencyValue) {
        if (currencyValue > moneyInWallet(currencyType) || currencyValue <= 0)
            throw new ArithmeticException("Insufficient Balance");
        else {
            if (currencyType.equalsIgnoreCase(Rupees.name)) {
                if (currencyValue <= Rupees.value)
                    Rupees.value -= currencyValue;
                else {
                    Dollars.value -= (currencyValue - Rupees.value) / dollarRupeeConversationRate;
                    Rupees.value = 0;
                }

            } else if (currencyType.equalsIgnoreCase(Dollars.name)) {
                if (currencyValue <= Dollars.value)
                    Dollars.value -= currencyValue;
                else {
                    Rupees.value -= (currencyValue - Dollars.value) * dollarRupeeConversationRate;
                    Dollars.value = 0;
                }
            }

        }
        return getCurrencyValue(currencyType);
    }

    public double moneyInWallet(String currencyType) {
        if (currencyType.equalsIgnoreCase("Rupees"))
            return (double) (Rupees.value + Dollars.value * dollarRupeeConversationRate);

        else if (currencyType.equalsIgnoreCase("Dollars"))
            return (double) (Dollars.value + Rupees.value / dollarRupeeConversationRate);

        else
            return 0.0;
    }
}
