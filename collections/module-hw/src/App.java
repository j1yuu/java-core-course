import java.util.Optional;
import model.Contact;
import repository.ContactsRepository;
import repository.impl.ContactsRepositoryImpl;
import service.ContactsService;
import service.impl.ContactsServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        ContactsRepository contactsRepository = new ContactsRepositoryImpl(Optional.empty());
        ContactsService contactsService = new ContactsServiceImpl(contactsRepository);

        contactsService.save("name", "phone", "email", "group");
        contactsService.save("name2", "phone2", "email2", "group2");
        contactsService.save("name3", "phone3", "email3", "group3");
        contactsService.save("name4", "phone4", "email4", "group4"); 

        for (Contact contact : contactsService.findAll()) {
            System.out.println(contact);
        }
    }
}
