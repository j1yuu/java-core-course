import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> usersFromDb = getSeedUsers();
        List<String> usersFromApi = getSeedUsers();

        System.out.println(usersFromDb);
        System.out.println(usersFromApi);

        System.out.println("\nLIST");
        System.out.println(usersFromDb.equals(usersFromApi));
        System.out.println(usersFromDb.size() == usersFromApi.size());

        Set<String> usersDbSet = new HashSet<>(usersFromDb);
        Set<String> usersApiSet = new HashSet<>(usersFromApi);
        
        System.out.println("\nSET");
        System.out.println(usersDbSet.equals(usersApiSet));

        System.out.println("\nINTERSECT");
        for (String user : usersDbSet) {
            if (usersApiSet.contains(user)) {
                System.out.println(user);
            }
        }
        
        System.out.println("\nLEFT USERS");
        for (String user : usersDbSet) {
            if (!usersApiSet.contains(user)) {
                System.out.println(user);
            }
        }

        System.out.println("\nRIGHT USERS");
        for (String user : usersApiSet) {
            if (!usersDbSet.contains(user)) {
                System.out.println(user);
            }
        }

    }

    private static List<String> getSeedUsers() {
        List<String> users = new ArrayList<>();

        for (int i = 0; i < 10; i ++) {
            if (i < 3) {
                users.add("user" + i);
            } else {
                users.add("user" + (int) (Math.random() * 1000));
            }
        }

        return users;
    }
}
