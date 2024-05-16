import java.util.ArrayList;

// ===== ABSTRACT BASE USER CLASS =====
public abstract class User {

    // Static variable to keep track of the total users that the app has
    private static int totalNumberOfUsersTillDate = 0;

    // Every user will have an ID and a shopping cart
    private int userId;
    private ShoppingCart shoppingCart;

    // Constructor
    public User(int userId) {
        this.userId = userId;
        this.shoppingCart = new ShoppingCart();

        // Increment the total number of users
        totalNumberOfUsersTillDate++;
    }

    // Method to get the total number of users till date
    public static int getTotalNumberOfUsersTillDate() {
        return totalNumberOfUsersTillDate;
    }

    // Methods below are protected because no other classes apart from the subclasses will need them
    // Get the UserID of a user
    protected int getUserId() {
        return userId;
    }

    // Get the shopping cart of a user
    protected ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    // Abstract function to print the user Details
    protected abstract void getUserDetails();
}
