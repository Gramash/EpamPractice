package ua.nure.garmash.Practice7.entity;

public class MedPackage {
    private String type;
    private int amount;
    private double price;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Package description {" +
                "type: '" + type + '\'' +
                ", amount: " + amount +
                ", price: " + price +
                '}';
    }
}
