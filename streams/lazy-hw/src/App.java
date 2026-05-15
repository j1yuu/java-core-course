import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = Arrays.asList(new Integer[10]);

        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, i);
        }

        System.out.println(
            numbers.stream()
                .filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .map(i -> i * i)
                .collect(Collectors.toList())
        );
    }
}
