import java.util.HashMap;
import java.util.Map;

public class App {
    private static final String APPLE = "Apple";
    private static final String ORANGE = "Orange";
    private static final String BANANA = "Banana";
    private static final String MILK = "Milk";

    public static void main(String[] args) throws Exception {
        Map<String, Integer> stock = new HashMap<>();

        stock.put(APPLE, 10);
        stock.put(ORANGE, 5);
        stock.put(BANANA, 20);
        stock.put(MILK, 15);

        addStock(stock, APPLE, 10);

        
        try {
            sellItem(stock, ORANGE, 3);
            sellItem(stock, ORANGE, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        displayStock(stock);
    }

    private static void displayStock(Map<String, Integer> stock) {
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void addStock(Map<String, Integer> stock, String item, int quantity) {
        if (stock.containsKey(item)) {
            stock.put(item, stock.get(item) + quantity);
        } else {
            stock.put(item, quantity);
        }

        System.out.println("Added " + quantity + " " + item + " to stock");
    }

    private static void sellItem(Map<String, Integer> stock, String item, int quantity) {
        if (!stock.containsKey(item) || stock.get(item) < quantity) {
            throw new RuntimeException("Not enough " + item + " in stock");
        }

        stock.put(item, stock.get(item) - quantity);

        System.out.println("Sold " + quantity + " " + item);
    }
}
