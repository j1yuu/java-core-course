package entities;

public class Newspaper extends Publication {
  private String publicationDay;

  public Newspaper(String title, String author, int year, String publicationDay) {
    super(title, author, year);
    this.publicationDay = publicationDay;
  }

  public String getPublicationDay() {
    return publicationDay;
  }

  public void setPublicationDay(String publicationDay) {
    this.publicationDay = publicationDay;
  }

  @Override
  public String getType() {
    return PublicationType.NEWSPAPER;
  }

  @Override
  public void printDetails() {
    System.out.println();
    System.out.println("Title: " + getTitle());
    System.out.println("Author: " + getAuthor());
    System.out.println("Year: " + getYear());
    System.out.println("Publication Day: " + getPublicationDay());
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
    Newspaper other = (Newspaper) obj;
    if (publicationDay == null) {
      if (other.publicationDay != null) {
        return false;
      }
    } else if (!publicationDay.equals(other.publicationDay)) {
      return false;
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((publicationDay == null) ? 0 : publicationDay.hashCode());
    return result;
  }
}