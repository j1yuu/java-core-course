package entities;

public class Magazine extends Publication {
  private int issueNumber;

  public Magazine(String title, String author, int year, int issueNumber) {
    super(title, author, year);
    this.issueNumber = issueNumber;
  }

  public int getIssueNumber() {
    return issueNumber;
  }

  public void setIssueNumber(int issueNumber) {
    if (issueNumber < 0) {
      System.out.println("Invalid issue number. Issue number should be greater than 0.");
      return;
    }
    
    this.issueNumber = issueNumber;
  }

  @Override
  public String getType() {
    return PublicationType.MAGAZINE;
  }

  @Override
  public void printDetails() {
    System.out.println();
    System.out.println("Title: " + getTitle());
    System.out.println("Author: " + getAuthor());
    System.out.println("Year: " + getYear());
    System.out.println("Issue Number: " + getIssueNumber());
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
    Magazine other = (Magazine) obj;
    if (issueNumber != other.issueNumber) {
      return false;
    }
    
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + issueNumber;
    return result;
  }

  @Override
  public String toString() {
    return "Magazine(title='" + getTitle() + "', author='" + getAuthor() + "', year=" + getYear() + ", issueNumber=" + issueNumber + ")";
  }
}
