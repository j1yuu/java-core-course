package repository;

import java.util.List;
import java.util.Optional;
import model.Contact;

public interface ContactsRepository {
  void save(Contact contact);

  void delete(Contact contact);
  
  void update(Contact contact);
  
  List<Contact> findAll();

  Optional<Contact> findByPhone(String phone);

  List<Contact> findByName(String name);
  
  List<Contact> findByEmail(String email);
  
  List<Contact> findByGroup(String group);
}
