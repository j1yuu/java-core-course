package storage;

import entities.Publication;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс библиотеки публикаций.
 *
 * <p>Используется как хранилище публикаций с возможностью поиска,
 * добавления, удаления и очистки списка публикаций.</p>
 */
public class Library {
  private final List<Publication> publications = new ArrayList<>();

  public List<Publication> getPublications() {
    if (publications.isEmpty()) {
      System.out.println("The library is empty");
    }
    return List.copyOf(publications);
  }

  public void setPublications(List<Publication> publications) {
    this.publications.clear();
    this.publications.addAll(List.copyOf(publications));
  }

  public void addPublication(Publication pub) {
    publications.add(pub);
  }

  public void clearPublications() {
    publications.clear();
  }

  public void removePublication(Publication pub) {
    boolean removed = publications.remove(pub);

    if (removed) Publication.decreasePublicationsCount();
  }

  public List<Publication> searchPublications(Predicate<Publication> condition) {
    if (condition == null) {
      System.err.println("Search can't be empty");
      return new ArrayList<>();
    }

    List<Publication> result = new ArrayList<>();

    for (Publication pub : publications) {
      if (condition.test(pub)) {
        result.add(pub);
      }
    }

    return result;
  }
}
