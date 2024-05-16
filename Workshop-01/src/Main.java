import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creating an array of 5 products using helper function
        ArrayList<Product> products = Helper.createProducts();

        // Checking to see whether the products were creating by printing out the details of the first product
        System.out.println("\nProduct details:");
        products.getFirst().getProductDetails();

        // Create a Registered User
        RegisteredUser registeredUser = new RegisteredUser(1, "aryan@gmail.com", "123456");

        // Printing the Details of the registered user
        System.out.println("\nRegistered user details:");
        registeredUser.getUserDetails();

        // Create a Guest user
        GuestUser guestUser = new GuestUser(2);
        System.out.println("\nGuest user details:");
        guestUser.getUserDetails();

        // Add all products to the registered user's shopping cart
        System.out.println("\n** Adding all products to the registered user's shopping cart **");
        for (Product product: products) {
            registeredUser.getShoppingCart().addProductToCart(product);
        }

        // Printing the Details of the registered user again to see if the new items were added
        System.out.println("\nRegistered user details after adding products:");
        registeredUser.getUserDetails();

        // Add the first 3 products to the Guest User
        System.out.println("\n** Adding the first 3 products to the guest user's shopping cart **");
        for (int i = 0; i < 3; i++) {
            guestUser.getShoppingCart().addProductToCart(products.get(i));
        }

        // Printing the Details of the guest user again to see if the new items were added
        System.out.println("\nGuest user details after adding products:");
        guestUser.getUserDetails();

        // Checking how many users we have created by leveraging the static variable declared in the User abstract class
        System.out.println("\n--------------------------------------------------");
        System.out.println("Total number of users created till date: " + User.getTotalNumberOfUsersTillDate());
        System.out.println("--------------------------------------------------");

        // Let us remove the 'Apple MacBook Pro 16-inch' from the registered user's cart and put it in the first position in Guest user's cart
        // Removing from reg user's cart
        registeredUser.getShoppingCart().removeProductFromCart("Apple MacBook Pro 16-inch");

        // Printing the Details of the registered user again to see if the item was removed
        System.out.println("\nRegistered user details after removing product:");
        registeredUser.getUserDetails();

        // Adding the 'Apple MacBook Pro 16-inch' at the start of the Guest User's Shopping Cart
        guestUser.getShoppingCart().addProductToCart(products.get(4), 0);

        // Printing the Details of the guest user again to see if the item was added
        System.out.println("\nGuest user details after adding product:");
        guestUser.getUserDetails();

        // Calculate the total price for the shopping list of both user's
        System.out.println("\n--------------------------------------------------");
        System.out.println("Subtotal for the Registered User: " + registeredUser.getShoppingCart().calculateTotalPrice());
        System.out.println("Subtotal for the Guest User: " + guestUser.getShoppingCart().calculateTotalPrice());
        System.out.println("--------------------------------------------------");
    }
}
