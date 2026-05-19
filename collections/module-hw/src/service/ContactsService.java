package service;

import java.util.Optional;
import model.Contact;

public interface ContactsService {
  void save(String name, String phone, String email, String group);

  void delete(String phone);
  
  void update(String name, String phone, String email, String group);
  
  Iterable<Contact> findAll();
  
  Optional<Contact> findByPhone(String phone);
  
  Iterable<Contact> findByName(String name);
  
  Iterable<Contact> findByEmail(String email);
  
  Iterable<Contact> findByGroup(String group);
}
