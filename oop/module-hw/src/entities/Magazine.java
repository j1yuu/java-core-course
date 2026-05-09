package entities;

public class Magazine extends Publication {
  private String issueNumber;

  public Magazine(String title, String author, int year, String issueNumber) {
    super(title, author, year);
    this.issueNumber = issueNumber;
  }

  public String getIssueNumber() {
    return issueNumber;
  }

  public void setIssueNumber(String issueNumber) {
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
    if (issueNumber == null) {
      if (other.issueNumber != null) {
        return false;
      }
    } else if (!issueNumber.equals(other.issueNumber)) {
      return false;
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((issueNumber == null) ? 0 : issueNumber.hashCode());
    return result;
  }
}
