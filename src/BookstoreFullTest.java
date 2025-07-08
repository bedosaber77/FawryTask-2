public class BookstoreFullTest {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        // Test adding books
        System.out.println("--- Testing Add Books ---");
        PaperBook paperBook1 = new PaperBook("978-1234567890", "The Great Gatsby", "alice gracful", 2000, 15.99, 10);
        EBook ebook1 = new EBook("PDF", "Digital Future", "John Doe", "978-0987654321", 2023, 9.99);
        Demo demoBook1 = new Demo("Sample Book", "Jane Smith", "978-1111111111", 2024, 0.0);

        store.addBook(paperBook1);
        store.addBook(ebook1);
        store.addBook(demoBook1);

        store.displayInventory();

        // Test buying books
        System.out.println("\n--- Testing Buy Books ---");
        try {
            double cost1 = store.BuySingleBook("978-1234567890", 2, "customer@email.com", "123 Main St");
            System.out.println("Total cost: $" + cost1);

            double cost2 = store.BuySingleBook("978-0987654321", 1, "customer@email.com", "123 Main St");
            System.out.println("Total cost: $" + cost2);
        } catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
        }

        // Test buying demo book (should fail)
        System.out.println("\n--- Testing Buy Demo Book (Should Fail) ---");
        try {
            store.BuySingleBook("978-1111111111", 1, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }


        System.out.println("\n--- Testing Buy Book Not In Inventory (Should Fail) ---");
        try {
            store.BuySingleBook("978-9999999999", 1, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Test adding a book that already exists in inventory
        System.out.println("\n--- Testing Add Duplicate Book ---");
        try {
            PaperBook duplicateBook = new PaperBook("978-1234567890", "The Great Gatsby", "alice gracful", 2000, 15.99, 5);
            store.addBook(duplicateBook);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        store.displayInventory();


        // Test removing outdated books
        System.out.println("\n--- Testing Remove Outdated Books ---");
        PaperBook oldBook = new PaperBook("978-1111111112", "Old Book", "Old Author", 1990, 5.99, 5);
        store.addBook(oldBook);

        store.removeOutdatedBook(30); // Remove books older than 30 years

        store.displayInventory();

        // Test stock limitation
        System.out.println("\n--- Testing Stock Limitation ---");
        try {
            store.BuySingleBook("978-1234567890", 20, "customer@email.com", "123 Main St"); // Should fail
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}