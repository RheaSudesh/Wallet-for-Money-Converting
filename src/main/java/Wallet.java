public class Wallet {

    String currencyName1 = "Rupees";
    String currencyName2 = "Dollars";
    double currencyValue1;
    double currencyValue2;
    final double dollarToRupeeConverstionRate = 78.84;

    public double convertToEquivalentCurrencyValue(String currencyType, double currencyValue) {

        if(currencyType.equalsIgnoreCase( currencyName1 ))
            return currencyValue / dollarToRupeeConverstionRate;
        else
            return currencyValue * dollarToRupeeConverstionRate;
    }

}
