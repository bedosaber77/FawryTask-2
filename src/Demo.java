public class Demo extends Book{
    public Demo(String title, String author, String ISBN, int year, double price) {
        super(ISBN,author,title,year,price);
    }


    @Override
    public double Buy(int quantity) {
        throw new IllegalArgumentException("Demo books are not for sale");
    }

    @Override
    public double Buy() {
        throw new IllegalArgumentException("Demo books are not for sale");
    }

}
