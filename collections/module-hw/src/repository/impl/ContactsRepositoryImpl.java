package repository.impl;

import exceptions.ContactAlreadyExistException;
import exceptions.ContactDoesNotExistException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import model.Contact;
import repository.ContactsRepository;

public class ContactsRepositoryImpl implements ContactsRepository {
  private final Set<Contact> contacts;

  public ContactsRepositoryImpl(Optional<Set<Contact>> contacts) {
    this.contacts = contacts.orElse(new LinkedHashSet<>());
  }

  @Override
  public void save(Contact contact) {
    if (contacts.contains(contact)) {
      throw new ContactAlreadyExistException("Contact already exist");
    }

    contacts.add(contact);
  }

  @Override
  public Iterable<Contact> findAll() {
    return Set.copyOf(contacts);
  }

  @Override
  public void delete(Contact contact) {
    if (!contacts.contains(contact)) {
      throw new ContactDoesNotExistException("Contact does not exist");
    }
    contacts.remove(contact);
  }

  @Override
  public void update(Contact contact) {
    Iterator<Contact> iterator = contacts.iterator();
    
    while (iterator.hasNext()) {
      Contact current = iterator.next();

      if (current.equals(contact)) {
        iterator.remove();
        contacts.add(contact);
        return;
      }
    }

    throw new ContactDoesNotExistException("Contact does not exist");
  }

  @Override
  public Optional<Contact> findByPhone(String phone) {
      for (Contact current : contacts) {
          if (current.getPhone().equals(phone)) {
              return Optional.of(current);
          }
      }

    return Optional.empty();
  }

  @Override 
  public Iterable<Contact> findByName(String name) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : contacts) {
      if (current.getName().equals(name)) {
        result.add(current);
      }
    }

    return result;
  }

  @Override 
  public Iterable<Contact> findByEmail(String email) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : contacts) {
      if (current.getEmail().equals(email)) {
        result.add(current);
      }
    }

    return result;
  }

  @Override 
  public Iterable<Contact> findByGroup(String group) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : contacts) {
      if (current.getGroup().equals(group)) {
        result.add(current);
      }
    }

    return result;
  }
}
