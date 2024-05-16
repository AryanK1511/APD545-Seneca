// ===== PRODUCT CLASS =====
public class Product {
    // Attributes
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;

    // Constructor
    public Product(int productId, String name, String description, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Get the name of the product
    protected String getProductName() {
        return this.name;
    }

    // Get the price of the product
    protected double getProductPrice() {
        return this.price;
    }

    // Print all the product details
    public void getProductDetails() {
        System.out.println("ID: " + this.productId);
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Price: " + this.price);
        System.out.println("Quantity: " + this.quantity);
    }

    // Print out the product name if we log the product type onto the console
    @Override
    public String toString() {
        return name;
    }
}
