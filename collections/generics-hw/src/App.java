
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) throws Exception {
    List<String> stringList = new ArrayList<>();
    
    stringList.add("string 1");
    stringList.add("string 2");
    stringList.add("string 3");

    for (String string : stringList) {
      System.out.println(string);
    }

    List rawCollection = new ArrayList();
    rawCollection.add(1);
    rawCollection.add("string");

    for (Object object : rawCollection) {
      String string = (String) object;
      System.out.println(string);
    }
  }
}
