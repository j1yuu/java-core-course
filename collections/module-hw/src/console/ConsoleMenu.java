package console;

import java.util.Scanner;

public class ConsoleMenu {
  private final Scanner scanner;

  public ConsoleMenu(Scanner scanner) {
    this.scanner = scanner;
  }

  public void show() {
    System.out.println("\nChoose an option (1-6):");
    System.out.println("1. Add contact");
    System.out.println("2. Update contact");
    System.out.println("3. Delete contact");
    System.out.println("4. Find contact");
    System.out.println("5. Find all contacts");
    System.out.println("0. Exit\n");
  }

  public String readCommand() {
    System.out.print("Enter command: ");
    return scanner.nextLine().trim();
  }
}
