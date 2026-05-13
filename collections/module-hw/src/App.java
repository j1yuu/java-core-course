import console.ConsoleApplication;
import console.ConsoleInputReader;
import console.ConsoleMenu;
import java.util.Optional;
import java.util.Scanner;
import repository.ContactsRepository;
import repository.impl.ContactsRepositoryImpl;
import service.ContactsService;
import service.impl.ContactsServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        ContactsRepository contactsRepository = new ContactsRepositoryImpl(Optional.empty());
        ContactsService contactsService = new ContactsServiceImpl(contactsRepository);

        ConsoleMenu consoleMenu = new ConsoleMenu(scanner);
        ConsoleInputReader consoleInputReader = new ConsoleInputReader(scanner);

        ConsoleApplication consoleApplication = new ConsoleApplication(
            scanner,
            contactsService,
            consoleInputReader,
            consoleMenu
        );

        consoleApplication.run();
    }
}
