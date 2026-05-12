package repository;

import java.util.Optional;
import model.Contact;

public interface ContactsRepository {
  void save(Contact contact);

  void delete(Contact contact);
  
  void update(Contact contact);
  
  Iterable<Contact> findAll();

  Optional<Contact> findByPhone(String phone);

  Iterable<Contact> findByName(String name);
  
  Iterable<Contact> findByEmail(String email);
  
  Iterable<Contact> findByGroup(String group);
}
