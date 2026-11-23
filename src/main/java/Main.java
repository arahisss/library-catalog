import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void getMenu() {
        String menu = """
                \nОпция 1: Добавить новую публикацию.
                Опция 2: Вывести список всех публикаций.
                Опция 3: Поиск публикации по автору.
                Опция 4: Вывести общее количество публикаций (используя статический метод).
                Опция 0: Выход""";
        System.out.println(menu);
    }

    public static int inputInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.nextLine();
            }
        }
    }

    public static void addPublication(Scanner scanner, Library library) {
        System.out.println("Выберите тип публикации: 1 – Book, 2 – Magazine, 3 – Newspaper");
        int typeChoice = inputInt(scanner);
        scanner.nextLine();

        if (typeChoice < 1 || typeChoice > 3) {
            System.out.println("Ошибка! Введите число от 1 до 3");
            return;
        }

        System.out.print("Введите название: ");
        String title = inputString(scanner);

        if (title == null) {
            System.out.println("Ошибка! Название не должно быть пустым");
            return;
        }

        System.out.print("Введите автора: ");
        String author = inputString(scanner);

        if (author == null) {
            System.out.println("Ошибка! Имя автора не должно быть пустым");
            return;
        }

        System.out.print("Введите год: ");
        int year;
        try {
            year = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Год должен быть целым числом");
            return;
        }

        switch (typeChoice) {
            case 1:
                System.out.print("Введите ISBN: ");
                String ISBN = inputString(scanner);
                if (ISBN == null) {
                    System.out.println("Ошибка! ISBN не должен быть пустым");
                    return;
                }
                library.addPublication(new Book(title, author, year, ISBN));
                break;
            case 2:
                System.out.print("Введите номер выпуска: ");
                int issueNumber;
                try {
                    issueNumber = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка! Номер выпуска должен быть целым числом");
                    return;
                }
                library.addPublication(new Magazine(title, author, year, issueNumber));
                break;
            case 3:
                System.out.print("Введите день публикации: ");
                String publicationDay = inputString(scanner);
                if (publicationDay == null) {
                    System.out.println("Ошибка! День публикации не должен быть пустым");
                    return;
                }
                library.addPublication(new Newspaper(title, author, year, publicationDay));
                break;
        }
    }

    public static String inputString(Scanner scanner) {
        String value = scanner.nextLine().trim();
        return value.isEmpty() ? null : value;
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            getMenu();
            int choice = inputInt(scanner);
            switch (choice) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    addPublication(scanner, library);
                    break;
                case 2:
                    library.listPublications();
                    break;
            }
        }
    }
}
