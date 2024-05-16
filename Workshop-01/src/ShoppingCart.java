import java.util.ArrayList;

// ===== SHOPPING CART CLASS =====
public class ShoppingCart {
    // Shopping cart can hold multiple products
    private ArrayList<Product> products;

    // Constructor
    public ShoppingCart() {
        this.products = new ArrayList<Product>();
    }

    // Get all the products in a shopping list
    public ArrayList<Product> getAllProductsInShoppingCart() {
        return this.products;
    }

    // Add a product at the end of the cart
    public void addProductToCart(Product product) {
        products.add(product);
    }

    // Add a product at a specific location in the cart
    public void addProductToCart(Product product, int index) {
        products.add(index, product);
    }

    // Remove a product from the end of the cart using the name of the product provided by user
    public void removeProductFromCart(String productName) {
        // Loop over all the products to see whether the productName provided by the user exists or not
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equalsIgnoreCase(productName)) {
                // If you find the product then remove it
                products.remove(i);
            }
        }
    }

    // Calculate the total price of all products
    public double calculateTotalPrice() {
        double sum = 0.0; // Initialize a counter

        // Add the price of each product in sum
        for (Product product : products) {
            sum += product.getProductPrice();
        }

        return sum;
    }
}
