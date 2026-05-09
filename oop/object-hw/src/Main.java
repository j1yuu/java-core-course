
import java.util.Objects;

class Item {
  private int count;
  private int weight;

  public Item(int count, int weight) {
    this.count = count;
    this.weight = weight;
  }

  public int getCount() {
    return count;
  }

  public int getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return "Item(count=" + count + ", weight=" + weight + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Item item = (Item) obj;

    return count == item.count && weight == item.weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, weight);
  }
}

public class Main {
  public static void main(String[] args) {
    Item item1 = new Item(10, 20);
    Item item2 = new Item(12, 24);
    
    Item[] items = {item1, item2};
    
    for (Item item : items) {
      System.out.println(item.toString());
      System.out.println(item.hashCode());
    }

    System.out.println(item1.equals(item2));
    System.out.println(item1.hashCode() == item2.hashCode());
  }  
}
