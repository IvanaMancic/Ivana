package enums;

public enum Currency {
    Dollar ("US Dollar"),
    Euro ("Euro");

    public String currency;

    Currency (String currency){
        this.currency=currency;
    }
}
