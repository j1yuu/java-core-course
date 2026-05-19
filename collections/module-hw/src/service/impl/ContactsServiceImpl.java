package service.impl;

import exceptions.ContactAlreadyExistException;
import exceptions.ContactDoesNotExistException;
import java.util.Optional;
import model.Contact;
import repository.ContactsRepository;
import service.ContactsService;

public class ContactsServiceImpl implements ContactsService {
  private final ContactsRepository contactsRepository;
  
  public ContactsServiceImpl(ContactsRepository contactsRepository) {
    this.contactsRepository = contactsRepository;
  }

  @Override
  public void save(String name, String phone, String email, String group) {
    Contact newContact = new Contact(name, phone, email, group);
    boolean result = contactsRepository.save(newContact);

    if (!result) {
      throw new ContactAlreadyExistException("Contact already exists");
    }
  }

  @Override
  public void delete(String phone) {
    Optional<Contact> contact = contactsRepository.findByPhone(phone);

    contact.ifPresentOrElse(contactsRepository::delete, () -> {
      throw new ContactDoesNotExistException("Contact does not exist");
    });
  }

  @Override
  public void update(String name, String phone, String email, String group) {
    Contact contact = new Contact(name, phone, email, group);

    boolean result = contactsRepository.update(contact);

    if (!result) {
      throw new ContactDoesNotExistException("Contact does not exist");
    }
  }

  @Override
  public Iterable<Contact> findAll() {
    return contactsRepository.findAll();
  }

  @Override
  public Optional<Contact> findByPhone(String phone) {
    if (phone == null || phone.trim().isEmpty()) {
      throw new IllegalArgumentException("Phone cannot be null or empty");
    }
  
    return contactsRepository.findByPhone(phone);
  }

  @Override
  public Iterable<Contact> findByName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
  
    return contactsRepository.findByName(name);
  }

  @Override
  public Iterable<Contact> findByEmail(String email) {
    if (email == null || email.trim().isEmpty()) {
      throw new IllegalArgumentException("Email cannot be null or empty");
    }
  
    return contactsRepository.findByEmail(email);
  }

  @Override
  public Iterable<Contact> findByGroup(String group) {
    if (group == null || group.trim().isEmpty()) {
      throw new IllegalArgumentException("Group cannot be null or empty");
    }

    return contactsRepository.findByGroup(group);
  }
  
}
