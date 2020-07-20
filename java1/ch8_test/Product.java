package ch8_test;

public class Product {
    private String description;
    private double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(String desscription, double price) {
        this.description = desscription;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "desscription=" + description + ", price=" + price + '}';
    }
}
