package repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import model.Contact;
import repository.ContactsRepository;

public class ContactsRepositoryImpl implements ContactsRepository {
  private final List<Contact> contactsInOrder;
  private final Set<Contact> uniqueContacts;
  private final Map<String, List<Contact>> contactsByGroup;

  public ContactsRepositoryImpl() {
    this.contactsInOrder = new LinkedList<>();
    this.uniqueContacts = new HashSet<>();
    this.contactsByGroup = new HashMap<>();
  }

  public ContactsRepositoryImpl(List<Contact> contacts) {
    this.contactsInOrder = new ArrayList<>(contacts);
    this.uniqueContacts = new HashSet<>(contacts);
    this.contactsByGroup = prepareContactsByGroup(contacts);
  }


  private Map<String, List<Contact>> prepareContactsByGroup(List<Contact> contacts) {
    Map<String, List<Contact>> newContactsByGroup = new HashMap<>();
    List<Contact> contactsCopy = List.copyOf(contacts);
    
    for (Contact contact : contactsCopy) {
      if (contact.getGroup() != null) {
        newContactsByGroup.putIfAbsent(contact.getGroup(), new ArrayList<>());
        newContactsByGroup.get(contact.getGroup()).add(contact);
      }
    }

    return newContactsByGroup;
  }

  @Override
  public boolean save(Contact contact) {
    if (uniqueContacts.contains(contact)) {
      return false;
    }

    contactsInOrder.add(contact);
    uniqueContacts.add(contact);
    
    if (contact.getGroup() != null) {
      contactsByGroup.putIfAbsent(contact.getGroup(), new ArrayList<>());
      contactsByGroup.get(contact.getGroup()).add(contact);
    }

    return true;
  }

  @Override
  public List<Contact> findAll() {
    return List.copyOf(contactsInOrder);
  }

  @Override
  public boolean delete(Contact contact) {
    if (!uniqueContacts.contains(contact)) {
      return false;
    }

    uniqueContacts.remove(contact);
    contactsInOrder.remove(contact);

    if (contact.getGroup() != null) {
      List<Contact> contactsGroup = contactsByGroup.get(contact.getGroup());

      if (contactsGroup != null) {
        contactsGroup.remove(contact);
      }
    }
    return true;
  }

  @Override
  public boolean update(Contact contact) {
    Optional<Contact> oldContact = findByPhone(contact.getPhone());
    if (oldContact.isPresent()) {
      delete(oldContact.get());
      return save(contact);
    }

    return false;
  }

  @Override
  public Optional<Contact> findByPhone(String phone) {
    for (Contact current : uniqueContacts) {
      if (current.getPhone().equals(phone)) {
        return Optional.of(current);
      }
    }
    return Optional.empty();
  }

  @Override 
  public List<Contact> findByName(String name) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : uniqueContacts) {
      if (current.getName().equals(name)) {
        result.add(current);
      }
    }  

    return result;
  }

  @Override 
  public List<Contact> findByEmail(String email) {
    List<Contact> result = new ArrayList<>();

    for (Contact current : uniqueContacts) {
      if (current.getEmail().equals(email)) {
        result.add(current);
      }
    }

    return result;
  }

  @Override 
  public List<Contact> findByGroup(String group) {
    return contactsByGroup.getOrDefault(group, new ArrayList<>());
  }
}
