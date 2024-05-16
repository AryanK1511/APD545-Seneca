public class RegisteredUser extends User {

    // Each registered user will have an email and password
    private String email;
    private String password;

    // Constructor
    public RegisteredUser(int userId, String email, String password) {
        super(userId);
        this.email = email;
        this.password = password;
    }

    // Print out the details of the user
    @Override
    public void getUserDetails() {
        System.out.println("ID: " + this.getUserId());
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Items in Cart: " + this.getShoppingCart().getAllProductsInShoppingCart());
    }
}
