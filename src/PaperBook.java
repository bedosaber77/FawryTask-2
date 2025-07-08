public class PaperBook extends Book {
    int Stock;
    PaperBook(String ISBN,String title, String author, int year, double price, int stock) {
        super(ISBN,author,title,year,price);
        this.Stock = stock;
    }

    @Override
    public double Buy(int quantity) {
        if(quantity > Stock)
            throw new IllegalArgumentException("quantity exceeds stock");
        else{
            this.Stock -= quantity;
            return quantity* this.Price;
        }
    }
    @Override
    public double Buy() {
        return Buy(1);
    }


}
