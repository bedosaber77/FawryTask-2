import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class BookStore {
    ArrayList<Book> inventory;
    BookStore() {
        inventory = new ArrayList<>();
    }
    void addBook(Book book) {
        if(inventory.contains(book)) {
            throw new IllegalArgumentException("Book already exists");
        }
        inventory.add(book);
        System.out.println("Added book " + book.getTitle() + " to the inventory");
    }

    void removeOutdatedBook(int year) {
        int currentYear = LocalDate.now().getYear();
        Iterator<Book> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (currentYear - book.getYear() >= year) {
                iterator.remove();
                System.out.println("Removed outdated book - " + book.getTitle());
            }
        }
    }

    double BuySingleBook(String isbn,int quantity, String email,String address) {
        for (Book book : inventory) {
            if(book.getISBN().equals(isbn)) {
                if(book instanceof EBook)
                {
                    double cost = book.Buy();
                    MailService.SendMail((EBook)book,email);
                    return cost;
                }
                if(book instanceof PaperBook){
                    double cost = book.Buy(quantity);
                    ShippingService.Ship((PaperBook)book,address);
                    return cost;
                }
                else if (book instanceof Demo) {
                    throw new IllegalArgumentException("Demo books are not for sale");
                }
            }
        }
        throw new IllegalArgumentException("Book not found");
    }


    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Book book : inventory) {
            String type = book.getClass().getSimpleName();
            System.out.println("- " + type + ": " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getISBN() + ")");
        }
    }
}
