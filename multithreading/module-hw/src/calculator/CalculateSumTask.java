package calculator;

import java.util.List;
import java.util.concurrent.Callable;

public class CalculateSumTask implements Callable<Integer> {
  private List<Integer> numbersList;
  private String taskName;

  public CalculateSumTask(List<Integer> numbersList, String taskName) {
    this.numbersList = List.copyOf(numbersList);
    this.taskName = taskName;
  }

  @Override
  public Integer call() throws Exception {
    System.out.println("Task: " + taskName + ", Thread: " + Thread.currentThread().getName());

    Thread.sleep(200);

    return numbersList.stream().reduce(0, Integer::sum);
  }

}
