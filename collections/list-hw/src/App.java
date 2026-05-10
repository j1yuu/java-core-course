
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class App {
  public static void main(String[] args) throws Exception {
    List<String> tasksList = new ArrayList<>();

    tasksList.add("Task 1");
    tasksList.add("Task 2");
    tasksList.add("Task 3");

    System.out.println(tasksList.get(1));

    tasksList.add(((int) Math.floor(tasksList.size() / 2)), "Task 4");

    System.out.println(tasksList.get(1));

    tasksList.remove(((int) Math.floor(tasksList.size() / 2)));

    System.out.println(tasksList.get(1));

    List<String> tasksList2 = new LinkedList<>();

    tasksList2.add("Task 1");
    tasksList2.add("Task 2");
    tasksList2.add("Task 3");

    System.out.println(tasksList2.get(1));

    tasksList2.add(((int) Math.floor(tasksList2.size() / 2)), "Task 4");

    System.out.println(tasksList2.get(1));

    tasksList2.remove(((int) Math.floor(tasksList2.size() / 2)));

    System.out.println(tasksList2.get(1));
  }
}
