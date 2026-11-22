public class Newspaper extends Publication {
    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    public String getType() {
        return "Газета";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", publicationDay: %s", publicationDay);
    }

    @Override
    public boolean equals(Object o) {
        Newspaper newspaper = (Newspaper) o;
        return super.equals(newspaper) && newspaper.getPublicationDay().equals(publicationDay);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + publicationDay.hashCode();
    }

    public String getPublicationDay() {
        return publicationDay;
    }
    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }
}
