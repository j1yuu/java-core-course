package entities;

public class Book extends Publication {
  private String isbn;

  public Book(String title, String author, int year, String isbn) {
    super(title, author, year);
    this.isbn = isbn;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public String getType() {
    return PublicationType.BOOK;
  }

  @Override
  public void printDetails() {
    System.out.println();
    System.out.println("Title: " + getTitle());
    System.out.println("Author: " + getAuthor());
    System.out.println("Year: " + getYear());
    System.out.println("ISBN: " + getIsbn());
    System.out.println();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Book other = (Book) obj;
    if (isbn == null) {
      if (other.isbn != null) {
        return false;
      }
    } else if (!isbn.equals(other.isbn)) {
      return false;
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
    return result;
  }
}