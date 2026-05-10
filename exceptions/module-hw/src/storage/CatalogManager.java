package storage;

import exceptions.EmptyCatalogException;
import exceptions.NoAvailableCopiesException;
import exceptions.NoSuchABookException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

public 
class CatalogManager {
  private final List<Book> catalog = new ArrayList<>();

  public void addBook(Book book) {
    if (book == null) {
      throw new IllegalArgumentException();
    }
  
    catalog.add(book);
  }

  public void removeBook(Book book) throws NoSuchABookException {
    if (book == null) {
      throw new IllegalArgumentException();
    }

    if (!catalog.contains(book)) {
      throw new NoSuchABookException();
    }
  
    catalog.remove(book);
  }

  public List<Book> getCatalog() throws EmptyCatalogException {
    if (catalog.isEmpty()) {
      throw new EmptyCatalogException();
    }
    return List.copyOf(catalog);
  }

  public void setCatalog(List<Book> catalog) {
    if (catalog == null) {
      throw new IllegalArgumentException();
    }

    this.catalog.clear();
    this.catalog.addAll(catalog);
  }

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

    book.setAvailableCopies(book.getAvailableCopies() - 1);

    return book;
  }

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

    catalog.get(index).setAvailableCopies(catalog.get(index).getAvailableCopies() + 1);
  }
}