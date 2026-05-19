package storage;

import java.util.ArrayList;
import java.util.List;
import model.Book;

public class Storage {
  private static final List<Book> catalog = new ArrayList<>();

  public static List<Book> getCatalog() {
    return catalog;
  }
}
