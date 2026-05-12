
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("string 1");
        hashSet.add("string 3");
        hashSet.add("string 2");

        for (String element : hashSet) {
            System.out.println(element); // -> string 3, string 2, string 1
        }

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("string 1");
        linkedHashSet.add("string 3");
        linkedHashSet.add("string 2");

        for (String element : linkedHashSet) {
            System.out.println(element); // -> string 1, string 3, string 2
        }

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("string 1");
        treeSet.add("string 3");
        treeSet.add("string 2");

        for (String element : treeSet) {
            System.out.println(element); // -> string 1, string 2, string 3
        }
    }
}
