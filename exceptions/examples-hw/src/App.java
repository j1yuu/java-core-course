import java.util.HashMap;
import java.util.Map;

class OrderValidationException extends Exception {
    public OrderValidationException() {
        super();
    }

    public OrderValidationException(String message) {
        super(message);
    }
}

class InventoryService {
    private final Map<String, Integer> inventory = new HashMap<>();

    public InventoryService () {
        inventory.put("1", 10);
        inventory.put("2", 5);
        inventory.put("3", 0);
        inventory.put("4", 20);
        inventory.put("5", 2);
    }

    public boolean checkAvailability(String productId) {
        if ("tech-error".equals(productId)) throw new IllegalStateException("Something went wrong");

        if (!inventory.containsKey(productId)) return false;

        return inventory.get(productId) > 0;
    }
}

class OrderService {
    private final InventoryService inventoryService;

    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void placeOrder(String productId, int quantity) throws OrderValidationException {
        if (productId == null || productId.isEmpty()) {
            throw new OrderValidationException("Invalid product id. Product id cannot be null or empty, given: " + productId);
        }

        if (quantity <= 0) {
            throw new OrderValidationException("Invalid quantity. Quantity must be greater than 0, given: " + quantity);
        }

        try {
            boolean available = inventoryService.checkAvailability(productId);
            
            if (!available) {
                throw new OrderValidationException("Product " + productId + " is not available");
            }

            System.out.println("Placing order for product " + productId + " with quantity " + quantity);
        } catch (IllegalStateException e) {
            System.out.println("Technical error: " + e.getMessage());
            throw new OrderValidationException("Something went wrong");
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        InventoryService inventoryService = new InventoryService();
        OrderService orderService = new OrderService(inventoryService);
        
        Map<String, Integer> testOrders = new HashMap<>(Map.ofEntries(
            Map.entry("1", 2),
            Map.entry("2", 31),
            Map.entry("tech-error", 4),
            Map.entry("", 5)
        ));

        for (Map.Entry<String, Integer> entry : testOrders.entrySet()) {
            try {
                orderService.placeOrder(entry.getKey(), entry.getValue());
            } catch (OrderValidationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
