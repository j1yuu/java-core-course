public class App {
  public static void main(String[] args) throws Exception {
    // неявное приведение примитива
    int num = 10;
    double num2 = num;
    System.out.println(num2);

    // явное приведение с потерей данных
    double num3 = 10.5;
    int num4 = (int) num3;
    System.out.println(num4);

    // upcasting
    String str = "Hello";
    Object obj = str;
    System.out.println(obj);

    // downcasting
    Object obj2 = "Hello";

    if (obj2 instanceof String str2) {
      System.out.println(str2);
    } else {
      System.out.println("Error");
    }
  }
}
