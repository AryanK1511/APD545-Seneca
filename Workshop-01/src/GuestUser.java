public class GuestUser extends User{

    // Constructor
    public GuestUser(int userId) {
        super(userId);
    }

    // Print out the details of the user
    @Override
    public void getUserDetails() {
        System.out.println("ID: " + this.getUserId());
        System.out.println("Items in Cart: " + this.getShoppingCart().getAllProductsInShoppingCart());
    }
}
