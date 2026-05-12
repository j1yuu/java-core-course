package service.impl;

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
    contactsRepository.save(newContact);
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

    contactsRepository.update(contact);
  }

  @Override
  public Iterable<Contact> findAll() {
    return contactsRepository.findAll();
  }

  @Override
  public Optional<Contact> findByPhone(String phone) {
    if (phone == null) {
      return Optional.empty();
    }
  
    return contactsRepository.findByPhone(phone);
  }

  @Override
  public Iterable<Contact> findByName(String name) {
    if (name == null) {
      return contactsRepository.findAll();
    }
  
    return contactsRepository.findByName(name);
  }

  @Override
  public Iterable<Contact> findByEmail(String email) {
    if (email == null) {
      return contactsRepository.findAll();
    }
  
    return contactsRepository.findByEmail(email);
  }

  @Override
  public Iterable<Contact> findByGroup(String group) {
    if (group == null) {
      return contactsRepository.findAll();
    }

    return contactsRepository.findByGroup(group);
  }
  
}
