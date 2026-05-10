public class ExceptionHandlingApp {
  public static void main(String[] args) throws Exception {
    runScenario();
  }

  public static void runScenario() {
    int[] array = {2, 1, 0};
    int iterations = 0;

    try {
      for (int i = 0; i <= array.length; i++) {
        System.out.println(iterations / array[i]);
        iterations++;
      }
    } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Exception: " + e.getClass() + "\nMessage: " + e.getMessage());
    } finally {
      System.out.println("Done, iterations: " + iterations + "\nExpected iterations: " + array.length);
    }
  }
}
