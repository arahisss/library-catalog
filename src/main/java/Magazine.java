public class Magazine extends Publication implements Printable {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    public String getType() {
        return "Журнал";
    }

    @Override
    public void printDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", issueNumber: %d}", issueNumber);
    }

    @Override
    public boolean equals(Object o) {
        Magazine magazine = (Magazine) o;
        return super.equals(magazine) && magazine.getIssueNumber() == issueNumber;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}
