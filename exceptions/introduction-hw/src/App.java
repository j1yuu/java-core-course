public class App {
  public static void main(String[] args) throws Exception {
    int a = 1;
    int b = 0;

    // System.out.println(a / b); // Exception in thread "main" java.lang.ArithmeticException: / by zero
    System.out.println(b / a);
  }
}
