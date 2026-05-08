final class Item {

  static int count = 0;
  static final String className = "Item";

  public Item() {
    count++;
  }

  public static int getCount() {
    return count;
  }
}

public class Main {

  public static void main(String[] args) {
    Item item1 = new Item();
    Item item2 = new Item();

    System.out.println("Invoked from object: " + item1.getCount());
    System.out.println("Invoked from class: " + Item.getCount());

    System.out.println("Class name: " + Item.className);
  }
}
