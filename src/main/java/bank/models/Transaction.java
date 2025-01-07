package bank.models;

public class Transaction {
    private String type;
    private double amount;
    private String date;
    private double tax;

    public Transaction(String type, double amount, String date, double tax) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.tax = tax;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getTax() {
        return tax;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return type + " of " + amount + " on " + date + (tax > 0 ? " (Tax: " + tax + ")" : "");
    }
}
