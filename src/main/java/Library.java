import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Publication> publications;

    public Library() {
        publications = new ArrayList<>();
    }

    public void addPublication(Publication pub) {
        this.publications.add(pub);
    }

    public void listPublications() {
        for (Publication pub : this.publications) {
            System.out.println(pub);
        }
    }

    public void searchByAuthor(String author) {
        for (Publication pub : this.publications) {
            if (pub.getAuthor().equals(author)) {
                System.out.println(pub);
            }
        }
    }

    public void deletePublication(Publication pub) {
        this.publications.remove(pub);
    }
}
