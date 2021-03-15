
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

    public double withdrawCurrency(String currencyType, double currencyValue) {
        if (currencyValue > moneyInWallet(currencyType) || currencyValue<=0)
            throw new ArithmeticException("Insufficient Balance");
        else {
            if (currencyType.equalsIgnoreCase(oneRupee.name)) {
                if (currencyValue <= oneRupee.value)
                    oneRupee.value -= currencyValue;
                else {
                    oneDollar.value -= (currencyValue - oneRupee.value) / dollarToRupeeConverstionRate;
                    oneRupee.value = 0;
                }

            } else if (currencyType.equalsIgnoreCase(oneDollar.name)) {
                if (currencyValue <= oneDollar.value)
                    oneDollar.value -= currencyValue;
                else {
                    oneRupee.value -= (currencyValue - oneDollar.value) * dollarToRupeeConverstionRate;
                    oneDollar.value = 0;
                }
            }

        }
        return getCurrencyvalue(currencyType);
    }

    public double moneyInWallet(String currencyType) {
        if (currencyType.equalsIgnoreCase("Rupees"))
            return (double) (oneRupee.value + oneDollar.value * dollarToRupeeConverstionRate);
        else if (currencyType.equalsIgnoreCase("Dollars"))
            return (double) (oneDollar.value + oneRupee.value / dollarToRupeeConverstionRate);
        else
            return 0.0;
    }
}
