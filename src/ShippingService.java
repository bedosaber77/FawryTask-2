public class ShippingService {
    public static void Ship(PaperBook book, String address) {
        System.out.println("Shipping " + book.getTitle() + " to address: " + address);
    }
}
