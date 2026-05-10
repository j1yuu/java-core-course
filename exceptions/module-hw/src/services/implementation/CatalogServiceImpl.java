package services.implementation;

import exceptions.EmptyCatalogException;
import exceptions.NoAvailableCopiesException;
import exceptions.NoSuchABookException;
import java.util.List;
import model.Book;
import services.CatalogService;
import storage.Storage;

public class CatalogServiceImpl implements CatalogService {
  private final List<Book> catalog = Storage.getCatalog();

  @Override
  public void addBook(Book book) {
    if (book == null) {
      throw new IllegalArgumentException();
    }
  
    catalog.add(book);
  }

  @Override
  public void removeBook(Book book) throws NoSuchABookException {
    if (book == null) {
      throw new IllegalArgumentException();
    }

    if (!catalog.contains(book)) {
      throw new NoSuchABookException();
    }
  
    catalog.remove(book);
  }


  @Override
  public List<Book> getCatalog() throws EmptyCatalogException {
    if (catalog.isEmpty()) {
      throw new EmptyCatalogException();
    }
    return List.copyOf(catalog);
  }

  @Override
  public void setCatalog(List<Book> catalog) {
    if (catalog == null) {
      throw new IllegalArgumentException();
    }

    this.catalog.clear();
    this.catalog.addAll(List.copyOf(catalog));
  }

  @Override
  public Book borrowBook(int index) throws NoAvailableCopiesException, EmptyCatalogException {
    if (catalog == null || catalog.isEmpty()) {
      throw new EmptyCatalogException();
    }
    
    if (index < 0 || index >= catalog.size()) {
      throw new IllegalArgumentException("Index should be between 1 and " + (catalog.size()) + ". Current input: " + index);
    }

    Book book = catalog.get(index);

    if (book.getAvailableCopies() == 0) {
      throw new NoAvailableCopiesException();
    }

    book.borrowOneCopy();

    return book;
  }

  @Override
  public void returnBook(int index) throws NoSuchABookException, EmptyCatalogException {
    if (catalog == null || catalog.isEmpty()) {
      throw new EmptyCatalogException();
    }

    if (index < 0 || index >= catalog.size()) {
      throw new IllegalArgumentException("Index should be between 1 and " + (catalog.size()) + ". Current input: " + (index + 1));
    }

    if (catalog.get(index) == null) {
      throw new NoSuchABookException();
    }

    catalog.get(index).returnOneCopy();
  }
}