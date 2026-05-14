
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> unprocessedList = List.of("ASD", "ssS", "hello", "WORLD", "asd", "hehe-haha", "ASd", "distinguished gentleman", "hehe-haha");

        List<String> processedList = unprocessedList.stream()
                .filter(s -> s.length() > 3)
                .map(s -> s.toUpperCase())
                .distinct()
                .sorted()
                .limit(3)
                .toList();

        System.out.println("Unprocessed list: " + unprocessedList);
        System.out.println("Processed list: " + processedList);
    }
}
