
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class User {
    private String id;
    private String email;

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(id, user.id);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        HashSet<User> users = new HashSet<>();

        users.add(new User("1", "a@b.com"));
        users.add(new User("1", "c@d.com"));

        System.out.println(users);

        User user1 = new User("1", "a@b.com");
        HashMap<User, String> usersDescription = new HashMap<>();

        usersDescription.put(user1, "User 1");

        System.out.println(usersDescription.get(user1));

        user1.setId("2");

        System.out.println(usersDescription.get(user1));
    }
}
