import entities.Book;
import entities.Magazine;
import entities.Newspaper;
import entities.Publication;
import entities.PublicationType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import storage.Library;

public class App {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Типобезопасное получение числового значения из консоли
   */
  private static int getNumberOption() {
    String option = scanner.nextLine();

    try {
      return Integer.parseInt(option);
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  public static void main(String[] args) throws Exception {
    Library lib = new Library();

    System.out.println("Welcome to Library Manager application");
    
    while (true) { 
      System.out.println("\nChoose an option from the list below (0-6):");
      System.out.println("1. Add a publication");
      System.out.println("2. List publications");
      System.out.println("3. Search for a publication");
      System.out.println("4. Print number of the publications created");
      System.out.println("5. Delete publication");
      System.out.println("6. Clear the library");
      System.out.println("0. Exit\n");

      System.out.print("Option: ");
      int option = getNumberOption();

      switch (option) {
        case 0 -> exitProgram();
        case 1 -> addPublication(lib);
        case 2 -> printAllPublications(lib);
        case 3 -> searchPublication(lib);
        case 4 -> System.out.println("Number of publications: " + Publication.getPublicationsCount());
        case 5 -> deletePublication(lib);
        case 6 -> clearPublications(lib);
        default -> System.out.println("Invalid option");
      }
    }
  }

  /**
   * Выход из программы
   */
  private static void exitProgram() {
    System.out.println("Goodbye!");
    System.exit(0);
  }

  /**
   * Метод для получения информации о публикации.
   */
  private static Publication gatherPublicationData(String type) {
    System.out.print("Title: ");
    String title = scanner.nextLine();

    System.out.print("Author: ");
    String author = scanner.nextLine();

    System.out.print("Year: ");
    int year = getNumberOption();

    if (year <= 0) {
      System.out.println("Invalid year. Year should be greater than 0.");
      return null;
    }

    switch (type.trim()) {
      case PublicationType.BOOK -> {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        return new Book(title, author, year, isbn);
      }
      case PublicationType.MAGAZINE -> {
        System.out.print("Issue Number: ");
        int issueNumber = getNumberOption();

        if (issueNumber <= 0) {
          System.out.println("Invalid issue number. Issue number should be greater than 0.");
          return null;
        }
        return new Magazine(title, author, year, issueNumber);
      }
      case PublicationType.NEWSPAPER -> {
        System.out.print("Publication Day: ");
        String publicationDay = scanner.nextLine();
        return new Newspaper(title, author, year, publicationDay);
      }
      default -> {
        System.out.println("Invalid type");
        return null;
      }
    }
  }

  private static void addPublication(Library lib) {
    System.out.println("\nChoose a publication type from the list below (0-3):");
    System.out.println("1. Book");
    System.out.println("2. Magazine");
    System.out.println("3. Newspaper");
    System.out.println("0. Back\n");

    System.out.print("Option: ");
    int option = getNumberOption();

    switch (option) {
      case 0 -> {}
      case 1 -> lib.addPublication(gatherPublicationData("Book"));
      case 2 -> lib.addPublication(gatherPublicationData("Magazine"));
      case 3 -> lib.addPublication(gatherPublicationData("Newspaper"));
      default -> System.out.println("Invalid option");
    }
  }

  private static void printGivenPublications(List<Publication> publications) {
    for (Publication pub : publications) {
      System.out.println(pub.toString());
    }
  }

  private static void printAllPublications(Library lib) {
    List<Publication> publications = lib.getPublications();
    
    printGivenPublications(publications);
  }

  private static void searchPublication(Library lib) {
    System.out.println("\nChoose a search condition from the list below (0-3):");
    System.out.println("1. Title");
    System.out.println("2. Author");
    System.out.println("3. Year");
    System.out.println("0. Back\n");

    System.out.print("Option: ");
    int option = getNumberOption();

    List <Publication> publications = new ArrayList<>();

    switch (option) {
      case 0 -> {}
      case 1 -> {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        publications = lib.searchPublications(pub -> pub.getTitle().equals(title));
      }
      case 2 -> {
        System.out.print("Author: ");
        String author = scanner.nextLine();
        publications = lib.searchPublications(pub -> pub.getAuthor().equals(author));
      }
      case 3 -> {
        System.out.print("Year: ");
        int year = getNumberOption();
        publications = lib.searchPublications(pub -> pub.getYear() == year);
      }
      default -> System.out.println("Invalid option");
    }

    printGivenPublications(publications);
  }

  private static void deletePublication(Library lib) {
    List<Publication> publications = lib.getPublications();

    System.out.println("\nChoose a publication from the list below (1-" + publications.size() + "):");
    
    for (int i = 0; i < publications.size(); i++) {
      Publication pub = publications.get(i);
      System.out.println((i + 1) + ". " + pub.getTitle() + " (type: " + pub.getType() + ")");
    }
    System.out.println("0. Back\n");

    System.out.print("Option: ");
    int option = getNumberOption();

    if (option == 0) {
      return;
    }

    if (option >= 1 && option <= publications.size()) {
      lib.removePublication(publications.get(option - 1));
      System.out.println("Publication removed successfully");
    } else {
      System.out.println("Invalid option");
    }
  }

  
  private static void clearPublications(Library lib) {
    System.out.println("\nAre you sure you want to clear the library? (y/n)");
    String input = scanner.nextLine();
    if (input.equals("y")) {
      lib.clearPublications();
      System.out.println("Library cleared successfully");
    }
  }

}
