package repository.impl;

import exceptions.ContactAlreadyExistException;
import exceptions.ContactDoesNotExistException;
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
  public void save(Contact contact) {
    if (contacts.containsKey(contact.getPhone())) {
      throw new ContactAlreadyExistException("Contact already exist");
    }

    contacts.put(contact.getPhone(), contact);
  }

  @Override
  public List<Contact> findAll() {
    return new LinkedList<>(contacts.values());
  }

  @Override
  public void delete(Contact contact) {
    if (!contacts.containsKey(contact.getPhone())) {
      throw new ContactDoesNotExistException("Contact does not exist");
    }
    contacts.remove(contact.getPhone());
  }

  @Override
  public void update(Contact contact) {
    if (contacts.containsKey(contact.getPhone())) {
      contacts.put(contact.getPhone(), contact);
      return;
    }

    throw new ContactDoesNotExistException("Contact does not exist");
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
