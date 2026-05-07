public class Main {
  public static void main(String[] args) {
    int value = 10;
    StringBuilder sb = new StringBuilder("Hello");

    changeValue(value);
    chabgeStringBuilder(sb);

    System.out.println(value);
    System.out.println(sb);
  }

  public static void changeValue(int value) {
    value = 20;
  }

  public static void chabgeStringBuilder(StringBuilder builder) {
    builder.append(", world");
  }
}
