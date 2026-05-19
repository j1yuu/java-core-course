package repository;

import java.util.List;
import java.util.Optional;
import model.Contact;

public interface ContactsRepository {
  boolean save(Contact contact);

  boolean delete(Contact contact);
  
  boolean update(Contact contact);
  
  List<Contact> findAll();

  Optional<Contact> findByPhone(String phone);

  List<Contact> findByName(String name);
  
  List<Contact> findByEmail(String email);
  
  List<Contact> findByGroup(String group);
}
