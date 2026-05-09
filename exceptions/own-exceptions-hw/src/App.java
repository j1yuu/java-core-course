class UserValidationException extends Exception {
    public UserValidationException() {
        super();
    }

    public UserValidationException(String message) {
        super(message);
    }
}

class UserService {
    public void register(String username, int age) {
        try {
            if (username == null || username.length() < 2) {
                throw new UserValidationException("Invalid username, passed: " + username + ", expected at least 2 characters");
            }
            if (age < 18) {
                throw new UserValidationException("Invalid age, passed: " + age + ", expected at least 18");
            }

            System.out.println("User registered successfully");
        } catch (UserValidationException e) {
            System.out.println(e.getMessage());
        }
    } 
}

public class App {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        userService.register(null, 16);
        userService.register("John", 14);
        userService.register("Jane", 20);
    }
}
