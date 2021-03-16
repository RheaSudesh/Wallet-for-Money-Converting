public class Wallet {

    Currency totalAmountInDollars = new Currency(CurrencyType.DOLLARS, 0);
    String dollars = CurrencyType.DOLLARS.getCurrencyName();
    double currencyConverstionRate = 74.85;

    public double depositCurrency(Currency currency) {
        if(currency.value == 0) throw new IllegalArgumentException(("Depositing of Zero valued currency is not supported"));
        else {
            totalAmountInDollars.value += currency.convertTo(dollars);
            return checkBalanceForCurrencyType(currency.name);
        }
    }

    public double withdrawCurrency(Currency currency) {
        double withdrawalAmountInDollars = currency.convertTo(dollars);

        if (withdrawalAmountInDollars == 0) throw new IllegalArgumentException("Withdrawal of Zero valued currency is not supported");
        else if (withdrawalAmountInDollars > totalAmountInDollars.value) throw new ArithmeticException("Insufficient Balance");
        else {
            totalAmountInDollars.value -= withdrawalAmountInDollars;
            return checkBalanceForCurrencyType(currency.name);
        }

    }

    public double checkBalanceForCurrencyType(CurrencyType currencyName) {
        if (currencyName.getCurrencyName().equalsIgnoreCase("Rupees"))
            return totalAmountInDollars.value * currencyConverstionRate;
        else
            return totalAmountInDollars.value ;
    }
}
