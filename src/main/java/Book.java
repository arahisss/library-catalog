public class Book extends Publication {
    private String title;
    private String author;
    private int year;
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    public String getType() {
        return "Книга";
    }

    @Override
    public String toString() {
        return String.format(
                "Название: %s, Автор: %s, Год: %d, ISBN: %s",
                title, author, year, ISBN
        );
    }

    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return super.equals(book) && book.getISBN().equals(ISBN);
    }

    @Override
    public int hashCode() {
        return super.hashCode() +  ISBN.hashCode();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
