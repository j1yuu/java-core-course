
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> stringList = List.of("hello", "world", "i'm", "learning", "bionicles", "lore");
        String[] stringArray = {"hello", "world", "i'm", "learning", "bionicles", "lore"};

        Stream<String> listStream = stringList.stream();
        Stream<String> arrayStream = Arrays.stream(stringArray);
        Stream<String> directStream = Stream.of("hello", "world", "i'm", "learning", "bionicles", "lore");

        System.out.println("List stream");
        List<String> listStreamResult = listStream.filter(s -> s.length() > 5).map(s -> s.toLowerCase()).collect(Collectors.toList());
        listStreamResult.forEach(System.out::println);
        System.out.println("");

        System.out.println("Array stream");
        List<String> arrayStreamResult = arrayStream.filter(s -> s.length() > 5).map(s -> s.toLowerCase()).collect(Collectors.toList());
        arrayStreamResult.forEach(System.out::println);
        System.out.println("");

        System.out.println("Direct stream");
        List<String> directStreamResult = directStream.filter(s -> s.length() > 5).map(s -> s.toLowerCase()).collect(Collectors.toList());
        directStreamResult.forEach(System.out::println);
    }
}
