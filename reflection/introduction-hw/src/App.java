import java.lang.reflect.Method;
import java.util.List;

class User {
    private int id;
    private String email;
    private String passwordHash;

    public User(int id, String email, String passwordHash) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public int getId() {
      return id;
    }

    public String getEmail() {
      return email;
    }

    public String getPasswordHash() {
      return passwordHash;
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
      this.passwordHash = passwordHash;
    }
}

class Order {
    private int id;
    private int userId;
    private List<String> items;

    public Order(int id, int userId, List<String> items) {
        this.id = id;
        this.userId = userId;
        this.items = List.copyOf(items);
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setItems(List<String> items) {
      this.items = items;
    }

    public void setUserId(int userId) {
      this.userId = userId;
    }

    public int getId() {
      return id;
    }

    public List<String> getItems() {
      return items;
    }

    public int getUserId() {
      return userId;
    }

    public int getTotatItemsCount() {
        return items.size();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Class<?> userClass = User.class;

        System.out.println(userClass.getName());
        System.out.println(userClass.getModifiers());
        System.out.println(userClass.getMethods());

        System.out.println("-----------");

        Class<?> orderClass = Order.class;

        System.out.println(orderClass.getName());
        System.out.println(orderClass.getModifiers());
        for (Method method : orderClass.getMethods()) {
            System.out.println(method.getName());
        }
    }
}
