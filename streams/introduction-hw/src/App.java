
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> marks = new ArrayList<>();

        marks.add("A");
        marks.add("B");
        marks.add("C");
        marks.add("D");
        marks.add("E");

        List<String> filteredMarks = new ArrayList<>();
        // Imperative
        for (String mark : marks) {
            if (mark.hashCode() <= "C".hashCode()) {
                filteredMarks.add(mark);
            }
        }

        for (String mark : filteredMarks) {
            System.out.println(mark);
        }

        // Declarative
        List<String> streamFilteredMarks = marks.stream()
            .filter(mark -> mark.hashCode() <= "C".hashCode())
            .toList();
        streamFilteredMarks.forEach(System.out::println);
    }
}
