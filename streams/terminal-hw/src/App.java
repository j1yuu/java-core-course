import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> ordersSums = List.of(320, 3040, 1235, 4000, 405, 320);

        List<Integer> sumUnder500 = ordersSums.stream().filter(s -> s <= 500).toList();
        long sumUnder500Count = sumUnder500.stream().count();

        System.out.println("Sum under 500 count: " + sumUnder500Count);
        sumUnder500.stream().forEach(System.out::println);
    }
}
