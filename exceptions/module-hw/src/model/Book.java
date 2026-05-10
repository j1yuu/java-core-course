package model;

import java.util.Objects;

public class Book extends Countable {
  private String title;
  private String author;

  public Book(String title, String author, int availableCopies) {
    super(availableCopies);

    this.title = title;
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public void setTitle(String title) {
    if (title == null || title.length() < 1) {
      throw new IllegalArgumentException("Title name should be at least 1 symbol long. Current input: " + title);
    }
    this.title = title;
  }

  public void setAuthor(String author) {
    if (author == null || author.length() < 1) {
      throw new IllegalArgumentException("Author name should be at least 1 symbol long. Current input: " + author);
    }
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" +
      "title='" + getTitle() + '\'' +
      ", author='" + getAuthor() + '\'' +
      ", availableCopies=" + getAvailableCopies() +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Book book = (Book) o;

    if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
    return getAuthor() != null ? getAuthor().equals(book.getAuthor()) : book.getAuthor() == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    return 31 * result + Objects.hash(getTitle(), getAuthor());
  }
}