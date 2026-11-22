public abstract class Publication {
    private static int publicationCount = 0;

    private String title;
    private String author;
    private int year;

    public abstract String getType();

    public static int getPublicationCount() {
        return publicationCount;
    }

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Название: %s, Автор: %s, Год: %d", title, author, year);
    }

    @Override
    public boolean equals(Object obj) {
        Publication p = (Publication) obj;
        return p.getTitle().equals(title)
                && p.getAuthor().equals(author)
                && p.getYear() == year;
    }

    @Override
    public int hashCode() {
        return title.hashCode() + author.hashCode() + year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
