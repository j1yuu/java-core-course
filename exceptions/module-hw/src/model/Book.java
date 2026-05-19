package model;

import java.util.Objects;

public class Book extends Countable {
  private String title;
  private String author;

  private static final int MAX_TITLE_LENGTH = 100;
  private static final int MIN_TITLE_LENGTH = 1;
  private static final int MAX_AUTHOR_LENGTH = 100;
  private static final int MIN_AUTHOR_LENGTH = 1;

  public Book(String title, String author, int availableCopies) {
    super(availableCopies);

    validateTitle(title);
    validateAuthor(author);

    this.title = title;
    this.author = author;
  }

  private boolean validateTitle(String title) {
    if (title == null || title.length() < MIN_TITLE_LENGTH) {
      throw new IllegalArgumentException("Title name should be at least 1 symbol long. Current input: " + title);
    }

    if (title.length() > MAX_TITLE_LENGTH) {
      throw new IllegalArgumentException("Title name should be less than 100 symbols long. Current input: " + title);
    }
    return true;
  }

  private boolean validateAuthor(String author) {
    if (author == null || author.length() < MIN_AUTHOR_LENGTH) {
      throw new IllegalArgumentException("Author name should be at least 1 symbol long. Current input: " + author);
    }

    if (author.length() > MAX_AUTHOR_LENGTH) {
      throw new IllegalArgumentException("Author name should be less than 100 symbols long. Current input: " + author);
    }
    return true;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public void setTitle(String title) {
    validateTitle(title);
  
    this.title = title;
  }

  public void setAuthor(String author) {
    validateAuthor(author);
  
    this.author = author;
  }

  public void borrowOneCopy() {
    setAvailableCopies(getAvailableCopies() - 1);
  }

  public void returnOneCopy() {
    setAvailableCopies(getAvailableCopies() + 1);
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