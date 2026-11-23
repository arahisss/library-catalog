public class Book extends Publication implements Printable {
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    public String getType() {
        return "Книга";
    }

    @Override
    public void printDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ISBN: %s", ISBN);
    }

    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return super.equals(book) && book.getISBN().equals(ISBN);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + ISBN.hashCode();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
