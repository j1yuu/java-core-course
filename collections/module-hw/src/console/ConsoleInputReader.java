package console;

import java.util.Scanner;

public class ConsoleInputReader {
  private final Scanner scanner;

  public ConsoleInputReader(Scanner scanner) {
    this.scanner = scanner;
  }

  public String readName() {
    System.out.print("Enter contact name: ");
    return scanner.nextLine();
  }

  public String readPhone() {
    System.out.print("Enter contact phone: ");
    return scanner.nextLine();
  }

  public String readEmail() {
    System.out.print("Enter contact email: ");
    return scanner.nextLine();
  }

  public String readGroup() {
    System.out.print("Enter group: ");
    return scanner.nextLine();
  }
}
