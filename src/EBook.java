public class EBook extends Book {
    String filetype;
    EBook(String filetype, String title, String author, String ISBN, int year, double price) {
        super(ISBN,author,title,year,price);
        this.filetype = filetype;
    }

    @Override
    public double Buy(int quantity) {
        return this.Price;
    }

    @Override
    public double Buy() {
        return this.Price;
    }
}
