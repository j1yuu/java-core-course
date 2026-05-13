package repository.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import model.Contact;
import repository.ContactsRepository;

public class ContactsRepositoryImpl implements ContactsRepository {
  private final Map<String, Contact> contacts;

  public ContactsRepositoryImpl(Optional<Map<String, Contact>> contacts) {
    this.contacts = contacts.orElse(new LinkedHashMap<>());
  }

  @Override
  public boolean save(Contact contact) {
    if (contacts.containsKey(contact.getPhone())) {
      return false;
    }

    contacts.put(contact.getPhone(), contact);
    return true;
  }

  @Override
  public List<Contact> findAll() {
    return new LinkedList<>(contacts.values());
  }

  @Override
  public boolean delete(Contact contact) {
    if (!contacts.containsKey(contact.getPhone())) {
      return false;
    }

    contacts.remove(contact.getPhone());
    return true;
  }

  @Override
  public boolean update(Contact contact) {
    if (contacts.containsKey(contact.getPhone())) {
      contacts.put(contact.getPhone(), contact);
      return true;
    }

    return false;
  }

  @Override
  public Optional<Contact> findByPhone(String phone) {
    if (contacts.containsKey(phone)) {
      return Optional.of(contacts.get(phone));
    }

    return Optional.empty();
  }

  @Override 
  public List<Contact> findByName(String name) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : contacts.values()) {
      if (current.getName().equals(name)) {
        result.add(current);
      }
    }

    return result;
  }

  @Override 
  public List<Contact> findByEmail(String email) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : contacts.values()) {
      if (current.getEmail().equals(email)) {
        result.add(current);
      }
    }

    return result;
  }

  @Override 
  public List<Contact> findByGroup(String group) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : contacts.values()) {
      if (current.getGroup().equals(group)) {
        result.add(current);
      }
    }

    return result;
  }
}
