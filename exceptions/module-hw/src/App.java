import exceptions.EmptyCatalogException;
import exceptions.NoAvailableCopiesException;
import exceptions.NoSuchABookException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Book;
import storage.CatalogManager;

public class App {
  private static final CatalogManager catalogManager = new CatalogManager();

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    List<Book> initialCatalog = new ArrayList<>();
    initCatalog(initialCatalog);
    catalogManager.setCatalog(List.copyOf(initialCatalog));

    System.out.println("Welcome to the Library!");
    while (true) {
      displayMenu(scanner);
    }
  }

  private static void initCatalog(List<Book> catalog) {
    catalog.add(new Book("Book 1", "Author 1", 10));
    catalog.add(new Book("Book 2", "Author 2", 5));
    catalog.add(new Book("Book 3", "Author 3", 15));
  }

  private static void menuOutput() {
    System.out.println("\nWhat would you like to do?");
    System.out.println("\n1. Add book\n2. Borrow book\n3. Return book\n4. Print catalog\n5. Exit");
  }

  private static void menuCase(int caseNumber, Scanner scanner) {
    switch (caseNumber) {
      case 1 -> addBookCase(scanner);
      case 2 -> borrowBookCase(scanner);
      case 3 -> returnBookCase(scanner);
      case 4 -> printCatalogCase();
      case 5 -> exitProgramCase();
      default -> System.out.println("\nInvalid input.");
    }
  }

  private static void displayMenu(Scanner scanner) {
    menuOutput();

    try {
      System.out.print("\nPick an option: ");
      int caseNumber = scanner.nextInt();
      scanner.nextLine();

      menuCase(caseNumber, scanner);
    } catch (InputMismatchException e) {
      System.out.println("\nInput should be a number.");
    }
  }

  private static void printCatalog() {
    try {
      List<Book> catalog = catalogManager.getCatalog();
      
      for (int i = 0; i < catalog.size(); i++) {
        Book book = catalog.get(i);

        System.out.println((i + 1) + ". " + book.toString());
      }

    } catch (EmptyCatalogException e) {
      System.out.println("\nCatalog is empty.");
    }
  }

  private static void printCatalogCase() {
    System.out.println("\nCurrent catalog state:");
    printCatalog();
  }

  private static void addBookCase(Scanner scanner) {
    try {
      System.out.print("\nEnter book title: ");
      String title = scanner.nextLine();

      System.out.print("Enter book author: ");
      String author = scanner.nextLine();

      System.out.print("Enter available copies: ");
      int availableCopies = scanner.nextInt();
      scanner.nextLine();

      Book book = new Book(title, author, availableCopies);
      catalogManager.addBook(book);

      System.out.println("\nAdded book: " + book.toString());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (InputMismatchException e) {
      System.out.println("\nAvailable copies should be a number.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void borrowBookCase(Scanner scanner) {
    try {
      System.out.println("\nEnter book index from the list below");
      printCatalog();

      System.out.print("\nIndex: ");
      int index = scanner.nextInt();
      scanner.nextLine();

      Book book = catalogManager.borrowBook(index - 1);

      System.out.println("\nBorrowed book: " + book.toString());
    
    } catch (InputMismatchException e) {
      System.err.println("\nIndex should be a number.");
    } catch(IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } catch (EmptyCatalogException e) {
      System.err.println("\nCatalog is empty.");
    } catch (NoAvailableCopiesException e) {
      System.err.println("\nThere are no available copies.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void returnBookCase(Scanner scanner) {
    try {
      System.out.println("\nEnter book index from the list below");
      printCatalog();

      System.out.print("\nIndex: ");
      int index = scanner.nextInt();
      scanner.nextLine();

      catalogManager.returnBook(index - 1);

      System.out.println("\nSuccessfully returned book.");
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } catch (NoSuchABookException e) {
      System.err.println("\nThere is no book with such index.");
    } catch (EmptyCatalogException e) {
      System.err.println("\nCatalog is empty.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void exitProgramCase() {
    System.out.println("\nGoodbye!");
    System.exit(0);
  }
}
