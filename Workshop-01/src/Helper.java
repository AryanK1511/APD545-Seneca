import java.util.ArrayList;

// ===== HELPER CLASS =====
public class Helper {

    // Function to generate 5 products
    public static ArrayList<Product> createProducts() {
        ArrayList<Product> products = new ArrayList<>();

        Product product1 = new Product(1, "Apple iPhone 13 Pro", "6.1-inch Super Retina XDR display. Ceramic Shield, tougher than any smartphone glass. 5G for superfast downloads and high-quality streaming. A14 Bionic, the fastest chip ever in a smartphone.", 999.00, 100);
        products.add(product1);

        Product product2 = new Product(2, "Samsung Galaxy S21 Ultra", "6.8-inch Dynamic AMOLED 2X display. 108 MP high-resolution camera. 8K video recording. 5,000 mAh battery. 5G connectivity.", 1199.99, 50);
        products.add(product2);

        Product product3 = new Product(3, "Amazon Echo Dot (4th Gen)", "Smart speaker with Alexa. Voice control your entertainment. Stream songs from Amazon Music, Apple Music, Spotify, SiriusXM, and others.", 49.99, 200);
        products.add(product3);

        Product product4 = new Product(4, "Sony WH-1000XM4 Wireless Headphones", "Industry-leading noise cancellation. Voice assistant Alexa. Dual noise sensor technology. Up to 30 hours of battery life.", 348.00, 75);
        products.add(product4);

        Product product5 = new Product(5, "Apple MacBook Pro 16-inch", "16-inch Retina display with True Tone. Up to 64GB of memory. Up to 8TB of storage. Magic Keyboard and Touch Bar. Six-speaker sound system.", 2399.00, 30);
        products.add(product5);

        return products;
    }
}
