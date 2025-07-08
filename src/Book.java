public abstract class Book {
    protected String ISBN;
    protected String Author;
    protected String Title;
    protected int Year;
    protected double Price;
    Book(String ISBN, String Author, String Title, int Year, double Price) {
        this.ISBN = ISBN;
        this.Author = Author;
        this.Title = Title;
        this.Year = Year;
        this.Price = Price;
    }

    int getYear() {
        return Year;
    }
    
    String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return Title;
    }
    public abstract double Buy(int quantity);
    public abstract double Buy();

    public String getAuthor() {
        return Author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN);
    }
}
