
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> tasks = new ArrayList<>();

        tasks.add("read book");
        tasks.add("send email");
        tasks.add("done: clean room");
        tasks.add("done: buy food");
        tasks.add("write code");

        Iterator<String> tasksIterator = tasks.iterator();

        while (tasksIterator.hasNext()) {
            if (tasksIterator.next().contains("done: ")) {
                tasksIterator.remove();
            }
        }

        for (String task : tasks) {
            System.out.println(task);
        }

        System.out.println("\n");

        tasks.add("done: clean room");
        tasks.add("done: buy food");
        tasks.add("learn something");
        tasks.add("done: smoke cig");

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).contains("done: ")) {
                tasks.remove(i);
            }
        }

        for (String task : tasks) {
            System.out.println(task);
        }

        System.out.println("\n");

        tasks.add("done: clean room");
        tasks.add("done: buy food");
        tasks.add("learn something");
        tasks.add("done: smoke cig");

        for (String task : tasks) {
            if (task.contains("done: ")) {
                tasks.remove(task);
            }
        }

        for (String task : tasks) {
            System.out.println(task);
        }
    }
}
