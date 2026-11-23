import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void getMenu() {
        String menu = """
                \nОпция 1: Добавить новую публикацию.
                Опция 2: Вывести список всех публикаций.
                Опция 3: Поиск публикации по автору.
                Опция 4: Вывести общее количество публикаций (используя статический метод).
                Опция 0: Выход""";
        System.out.println(menu);
    }

    public static int inputInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.nextLine();
            }
        }
    }

    public static int tryInputInt() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Ошибка! Значение должно быть целым числом");
            return -1;
        }
    }

    public static int inputPublicationType() {
        System.out.println("Выберите тип публикации: 1 – Book, 2 – Magazine, 3 – Newspaper");
        int typeChoice = tryInputInt();

        if (typeChoice == -1) return 0;

        if (typeChoice < 1 || typeChoice > 3) {
            System.out.println("Ошибка! Введите число от 1 до 3");
            return 0;
        }
        return typeChoice;
    }

    public static void addPublication(Library library, int publicationType) {
        System.out.print("Введите название: ");
        String title = inputString();

        if (title == null) {
            System.out.println("Ошибка! Название не должно быть пустым");
            return;
        }

        System.out.print("Введите автора: ");
        String author = inputString();

        if (author == null) {
            System.out.println("Ошибка! Имя автора не должно быть пустым");
            return;
        }

        System.out.print("Введите год: ");
        int year = tryInputInt();
        if (year == -1) return;

        switch (publicationType) {
            case 1:
                Book book = createBook(title, author, year);
                if (book != null) library.addPublication(book);
                break;
            case 2:
                Magazine magazine = createMagazine(title, author, year);
                if (magazine != null) library.addPublication(magazine);
                break;
            case 3:
                Newspaper newspaper = createNewspaper(title, author, year);
                if (newspaper != null) library.addPublication(newspaper);
                break;
        }
    }

    public static Book createBook(String title, String author, int year) {
        System.out.print("Введите ISBN: ");
        String ISBN = inputString();
        if (ISBN == null) {
            System.out.println("Ошибка! ISBN не должен быть пустым");
            return null;
        }
        return new Book(title, author, year, ISBN);
    }

    public static Magazine createMagazine(String title, String author, int year) {
        System.out.print("Введите номер выпуска: ");
        int issueNumber = tryInputInt();
        return issueNumber == -1 ? null : new Magazine(title, author, year, issueNumber);
    }

    public static Newspaper createNewspaper(String title, String author, int year) {
        System.out.print("Введите день публикации: ");
        String publicationDay = inputString();

        if (publicationDay == null) {
            System.out.println("Ошибка! День публикации не должен быть пустым");
            return null;
        }
        return new Newspaper(title, author, year, publicationDay);
    }


    public static String inputString() {
        String value = scanner.nextLine().trim();
        return value.isEmpty() ? null : value;
    }

    public static void main(String[] args) {
        Library library = new Library();

        boolean isRunning = true;

        while (isRunning) {
            getMenu();
            int choice = inputInt();
            switch (choice) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    int publicationType = inputPublicationType();
                    if (publicationType != 0) {
                        addPublication(library, publicationType);
                    }
                    break;
                case 2:
                    library.listPublications();
                    break;
            }
        }
    }
}
