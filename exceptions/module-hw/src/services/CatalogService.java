package services;

import exceptions.EmptyCatalogException;
import exceptions.NoAvailableCopiesException;
import exceptions.NoSuchABookException;
import java.util.List;
import model.Book;

public interface CatalogService {
  public void addBook(Book book);
  public void removeBook(Book book) throws NoSuchABookException;

  public List<Book> getCatalog() throws EmptyCatalogException;
  public void setCatalog(List<Book> catalog);

  public Book borrowBook(int index) throws NoAvailableCopiesException, EmptyCatalogException;
  public void returnBook(int index) throws NoSuchABookException, EmptyCatalogException;
}
