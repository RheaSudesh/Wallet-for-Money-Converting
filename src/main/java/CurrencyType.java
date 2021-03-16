public enum CurrencyType {
    DOLLARS("Dollars"),
    RUPEES("Rupees");

    private String name;

    private CurrencyType(String currencyName) {
        this.name = currencyName;
    }

    public String getCurrencyName(){
        return name;
    }
}
