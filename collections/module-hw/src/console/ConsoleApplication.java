package console;

import exceptions.ContactAlreadyExistException;
import java.util.Optional;
import java.util.Scanner;
import model.Contact;
import service.ContactsService;

public class ConsoleApplication {
  private final Scanner scanner;

  private final ContactsService contactsService;
  
  private final ConsoleInputReader consoleInputReader;
  private final ConsoleMenu consoleMenu;

  public ConsoleApplication(
    Scanner scanner,
    ContactsService contactsService,
    ConsoleInputReader consoleInputReader,
    ConsoleMenu consoleMenu
  ) {
    this.scanner = scanner;
    this.contactsService = contactsService;
    this.consoleInputReader = consoleInputReader;
    this.consoleMenu = consoleMenu;
  }

  public void run() {
    boolean running = true;

    System.out.println("Welcome to the contacts app!");
    while (running) {
      consoleMenu.show();
      String option = consoleMenu.readCommand();

      switch (option) {
        case "1" -> addContact();
        case "2" -> updateContact();
        case "3" -> deleteContact();
        case "4" -> findContact();
        case "5" -> findAllContacts();
        case "0" -> running = false;
        default -> System.out.println("Invalid option. Please try again.");
      }
    }

    System.out.println("Goodbye!");
  }

  private void addContact() {
    String name = consoleInputReader.readName();
    String phone = consoleInputReader.readPhone();
    String email = consoleInputReader.readEmail();
    String group = consoleInputReader.readGroup();

    try {
      contactsService.save(name, phone, email, group);

      System.out.println("\nContact saved successfully!");
    } catch (ContactAlreadyExistException e) {
      System.out.println("\n" + e.getMessage());
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void updateContact() {
    String name = consoleInputReader.readName();
    String phone = consoleInputReader.readPhone();
    String email = consoleInputReader.readEmail();
    String group = consoleInputReader.readGroup();

    try {
      contactsService.update(name, phone, email, group);

      System.out.println("\nContact updated successfully!");
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void deleteContact() {
    String phone = consoleInputReader.readPhone();

    try {
      contactsService.delete(phone);

      System.out.println("\nContact deleted successfully!");
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void findContact() {
    System.out.println("\nHow do you want to find the contact?");
    System.out.println("1. By phone");
    System.out.println("2. By name");
    System.out.println("3. By email");
    System.out.println("4. By group");

    String option = scanner.nextLine().trim();

    switch (option) {
      case "1" -> findContactByPhone();
      case "2" -> findContactsByName();
      case "3" -> findContactsByEmail();
      case "4" -> findContactsByGroup();
      default -> System.out.println("Invalid option. Please try again.");
    }
  }

  private void findContactByPhone() {
    try {
      String phone = consoleInputReader.readPhone();
      Optional<Contact> contact = contactsService.findByPhone(phone);

      if (contact.isPresent()) {
        System.out.println("\nContact found:");
        System.out.println(contact.get());
      } else {
        System.out.println("\nContact not found");
      }
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void findContactsByName() {
    try {
      String name = consoleInputReader.readName();
      Iterable<Contact> contacts = contactsService.findByName(name);

      printSearchResult(contacts);
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void findContactsByEmail() {
    
    try {
      String email = consoleInputReader.readEmail();
      Iterable<Contact> contacts = contactsService.findByEmail(email);

      printSearchResult(contacts);
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void findContactsByGroup() {
    try {
      String group = consoleInputReader.readGroup();
      Iterable<Contact> contacts = contactsService.findByGroup(group);

      printSearchResult(contacts);
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void findAllContacts() {
    try {
      Iterable<Contact> contacts = contactsService.findAll();

      printSearchResult(contacts);
    } catch (Exception e) {
      System.out.println("\nAn error occurred: " + e.getMessage());
    }
  }

  private void printContacts(Iterable<Contact> contacts) {
    int i = 1;

    for (Contact contact : contacts) {
        System.out.println(i + ". " + contact.toString());
        i++;
    }
  }

  private void printSearchResult(Iterable<Contact> contacts) {
    if (!contacts.iterator().hasNext()) {
      System.out.println("\nContacts not found");
      return;
    }

    System.out.println("\nContacts found:");
    printContacts(contacts);
  }
}
