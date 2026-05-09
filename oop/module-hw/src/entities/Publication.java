package entities;

/**
 * Абстрактный класс публикации.
 * 
 * <p>Используется для создания на его основе конкретных реализаций публикаций.</p>
 * 
 * <p>Содержит общие поля для всех публикаций: название, автор, год издания.</p>
 * 
 * @param title String title - название публикации, {@code private}
 * @param author String author - автор публикации, {@code private}
 * @param year int year - год издания, {@code private}
 * 
 * @param publicationsCount int publicationsCount - количество публикаций, {@code private static}
 * 
 * @see Printable
 */
public abstract class Publication implements Printable {
  private String title;
  private String author;
  private int year;

  private static int publicationsCount = 0;

  public Publication(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
    publicationsCount++;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYear() {
    return year;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setYear(int year) {
    if (year > 0) {
      this.year = year;
    } else {
      System.out.println("Invalid year. Year should be greater than 0.");
    }
  }

  public abstract String getType();

  public static int getPublicationsCount() {
    return publicationsCount;
  }

  public static void decreasePublicationsCount() {
    publicationsCount--;
  }

  @Override
  public String toString() {
    return "Publication(title='" + title + "', author='" + author + "', year=" + year + ")";
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Publication other = (Publication) obj;
    return title.equals(other.title) && author.equals(other.author) && year == other.year;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((author == null) ? 0 : author.hashCode());
    result = prime * result + year;
    return result;
  }

}