public class App {
  private String string;
  private int number;
  
  public static void main(String[] args) throws Exception {
    App app = new App();

    app.setString("Valid string");
    app.setNumber(12);

    System.out.println(app.getString());
    System.out.println(app.getNumber());
  }

  public String getString() {
    return string;
  }

  public int getNumber() {
    return number;
  }

  public void setString(String string) {
    if (string.length() < 3) {
      System.err.println("String too short");
      return;
    }
   
    this.string = string;
  }

  public void setNumber(int number) {
    if (number < 0) {
      System.err.println("Number too small");
      return;
    }

    this.number = number;
  }
}
