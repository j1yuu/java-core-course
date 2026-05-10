package cli;

import exceptions.EmptyCatalogException;
import exceptions.NoAvailableCopiesException;
import exceptions.NoSuchABookException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Book;
import services.CatalogService;

public class CliManager {
  private final Scanner scanner = new Scanner(System.in);
  private final CatalogService catalogService;

  public CliManager(CatalogService catalogService) {
    this.catalogService = catalogService;
  }

  public void run() {
    if (catalogService == null) {
      throw new IllegalArgumentException();
    }

    System.out.println("Welcome to the Library!");
    while (true) {
      displayMenu(scanner);
    }
  }

  private void menuOutput() {
    System.out.println("\nWhat would you like to do?");
    System.out.println("\n1. Add book\n2. Borrow book\n3. Return book\n4. Print catalog\n5. Exit");
  }

  private void menuCase(int caseNumber, Scanner scanner) {
    switch (caseNumber) {
      case 1 -> addBookCase(scanner);
      case 2 -> borrowBookCase(scanner);
      case 3 -> returnBookCase(scanner);
      case 4 -> printCatalogCase();
      case 5 -> exitProgramCase(scanner);
      default -> System.out.println("\nInvalid input.");
    }
  }

  private  void displayMenu(Scanner scanner) {
    menuOutput();

    try {
      System.out.print("\nPick an option: ");
      int caseNumber = scanner.nextInt();
      scanner.nextLine();

      menuCase(caseNumber, scanner);
    } catch (InputMismatchException e) {
      System.out.println("\nInput should be a number.");
      scanner.nextLine();
    }
  }

  private void printCatalog() {
    try {
      List<Book> catalog = catalogService.getCatalog();
      
      for (int i = 0; i < catalog.size(); i++) {
        Book book = catalog.get(i);

        System.out.println((i + 1) + ". " + book.toString());
      }

    } catch (EmptyCatalogException e) {
      System.out.println("\nCatalog is empty.");
    }
  }

  private  void printCatalogCase() {
    System.out.println("\nCurrent catalog state:");
    printCatalog();
  }

  private  void addBookCase(Scanner scanner) {
    try {
      System.out.print("\nEnter book title: ");
      String title = scanner.nextLine();

      System.out.print("Enter book author: ");
      String author = scanner.nextLine();

      System.out.print("Enter available copies: ");
      int availableCopies = scanner.nextInt();
      scanner.nextLine();

      Book book = new Book(title, author, availableCopies);
      catalogService.addBook(book);

      System.out.println("\nAdded book: " + book.toString());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (InputMismatchException e) {
      System.out.println("\nAvailable copies should be a number.");
      scanner.nextLine();
    } catch (Exception e) {
      System.err.println("Unexpected error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private  void borrowBookCase(Scanner scanner) {
    try {
      System.out.println("\nEnter book index from the list below");
      printCatalog();

      System.out.print("\nIndex: ");
      int index = scanner.nextInt();
      scanner.nextLine();

      Book book = catalogService.borrowBook(index - 1);

      System.out.println("\nBorrowed book: " + book.toString());
    
    } catch (InputMismatchException e) {
      System.err.println("\nIndex should be a number.");
      scanner.nextLine();
    } catch(IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } catch (EmptyCatalogException e) {
      System.err.println("\nCatalog is empty.");
    } catch (NoAvailableCopiesException e) {
      System.err.println("\nThere are no available copies.");
    } catch (Exception e) {
      System.err.println("Unexpected error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private  void returnBookCase(Scanner scanner) {
    try {
      System.out.println("\nEnter book index from the list below");
      printCatalog();

      System.out.print("\nIndex: ");
      int index = scanner.nextInt();
      scanner.nextLine();

      catalogService.returnBook(index - 1);

      System.out.println("\nSuccessfully returned book.");
    } catch (InputMismatchException e) {
      System.out.println("\nIndex should be a number.");
      scanner.nextLine();
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } catch (NoSuchABookException e) {
      System.err.println("\nThere is no book with such index.");
    } catch (EmptyCatalogException e) {
      System.err.println("\nCatalog is empty.");
    } catch (Exception e) {
      System.err.println("Unexpected error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private  void exitProgramCase(Scanner scanner) {
    scanner.close();
    System.out.println("\nGoodbye!");
    System.exit(0);
  }
}
