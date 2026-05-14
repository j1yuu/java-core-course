
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface 
interface Filter {
    boolean filter(String mark);
}

@FunctionalInterface
interface Collect {
    void collect(String mark, List<String> filteredMarks);
}


public class App {
    public static void main(String[] args) throws Exception {
        List<String> marks = new ArrayList<>();

        marks.add("A");
        marks.add("B");
        marks.add("C");
        marks.add("D");
        marks.add("E");

        // Imperative

        List<String> filteredMarks = new ArrayList<>();
        for (String mark : marks) {
            if (mark.hashCode() <= "C".hashCode()) {
                filteredMarks.add(mark);
            }
        }

        for (String mark : filteredMarks) {
            System.out.println(mark);
        }

        // Declarative
        Filter filter = (String mark) -> mark.hashCode() <= "C".hashCode();
        Collect collect = (String mark, List<String> marksCollection) -> {
            if (filter.filter(mark)) {
                marksCollection.add(mark); 
            }
        };

        List<String> declarativeFilteredMarks = new ArrayList<>();

        for (String mark : marks) {
            collect.collect(mark, declarativeFilteredMarks);
        }

        for (String mark : declarativeFilteredMarks) {
            System.out.println(mark);
        }
    }
}
