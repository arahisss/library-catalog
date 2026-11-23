import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        run(library);
    }

    public static void run(Library library) {
        boolean isRunning = true;

        while (isRunning) {
            getMenu();
            int choice = inputInt();
            if (choice < 0 || choice > 4) {
                System.out.println("Ошибка! Введите число от 0 до 4");
            }

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
                case 3:
                    searchByAuthor(library);
                    break;
                case 4:
                    System.out.println("Общее количество публикаций: " + Publication.getPublicationCount());
                    break;
            }
        }
    }

    public static void getMenu() {
        String menu = """
                \nОпция 1: Добавить новую публикацию.
                Опция 2: Вывести список всех публикаций.
                Опция 3: Поиск публикации по автору.
                Опция 4: Вывести общее количество публикаций.
                Опция 0: Выход""";
        System.out.println(menu);
    }

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    public static Integer tryInputInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Значение должно быть целым числом");
            return null;
        }
    }

    public static String inputString(String message, String errorMessage) {
        System.out.print(message);
        String value = scanner.nextLine().trim();

        if (value.isEmpty()) {
            System.out.println(errorMessage);
            return null;
        }
        return value;
    }

    public static int inputPublicationType() {
        System.out.println("Выберите тип публикации: 1 – Book, 2 – Magazine, 3 – Newspaper");
        Integer typeChoice = tryInputInt();

        if (typeChoice == null) return 0;

        if (typeChoice < 1 || typeChoice > 3) {
            System.out.println("Ошибка! Введите число от 1 до 3");
            return 0;
        }
        return typeChoice;
    }

    // 1 - Добавление публикации
    public static void addPublication(Library library, int publicationType) {
        String title = inputString(
                "Введите название: ",
                "Ошибка! Название не должно быть пустым"
        );
        if (title == null) return;

        String author = inputString(
                "Введите автора: ",
                "Ошибка! Имя автора не должно быть пустым"
        );
        if (author == null) return;

        System.out.print("Введите год: ");
        Integer year = tryInputInt();
        if (year == null) return;

        Publication publication = switch (publicationType) {
            case 1 -> createBook(title, author, year);
            case 2 -> createMagazine(title, author, year);
            case 3 -> createNewspaper(title, author, year);
            default -> null;
        };

        if (publication != null) library.addPublication(publication);
    }

    public static Book createBook(String title, String author, int year) {
        String ISBN = inputString(
                "Введите ISBN: ",
                "Ошибка! ISBN не должен быть пустым"
        );
        return ISBN == null ? null : new Book(title, author, year, ISBN);
    }

    public static Magazine createMagazine(String title, String author, int year) {
        System.out.print("Введите номер выпуска: ");
        Integer issueNumber = tryInputInt();
        return issueNumber == null ? null : new Magazine(title, author, year, issueNumber);
    }

    public static Newspaper createNewspaper(String title, String author, int year) {
        String publicationDay = inputString(
                "Введите день публикации: ",
                "Ошибка! День публикации не должен быть пустым"
        );
        return publicationDay == null ? null : new Newspaper(title, author, year, publicationDay);
    }

    // 3 - Поиск по автору
    public static void searchByAuthor(Library library) {
        String author = inputString("Введите имя автора: ", "Ошибка! Имя автора не должно быть пустым");
        if (author != null) library.searchByAuthor(author);
    }
}
