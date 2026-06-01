package processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import calculator.CalculateSumTask;

public class DataProcessor {
  private final ExecutorService service = Executors.newFixedThreadPool(10);
  private AtomicInteger tasksNumber = new AtomicInteger(0);
  private AtomicInteger activeTasks = new AtomicInteger(0);
  private final Map<String, Integer> resultMap = new HashMap<>();
  private final Object mapLock = new Object();

  public int getTasksNumber() {
    return tasksNumber.get();
  }

  public void insertAndExecuteTask(List<Integer> numbersToCalculate) {
    String taskName = "Task " + tasksNumber.get();
    
    CalculateSumTask task = new CalculateSumTask(numbersToCalculate, taskName);
    
    activeTasks.incrementAndGet();
    tasksNumber.incrementAndGet();

    service.submit(() -> {
      try {
        Integer res = task.call();

        synchronized (mapLock) {
          resultMap.put(taskName, res);
        }
      } catch (Exception e) {
        throw new RuntimeException("Failed processing task: " + taskName, e);
      } finally {
        activeTasks.decrementAndGet();
      }
    });
  
    return;
  }

  public void cancel() {
    service.shutdown();
    try {
      service.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      System.err.println("Interrupting while waiting for service to shutdown: " + e.getMessage());
    }
  }

  public Optional<Integer> getTaskResult(String taskName) {
    synchronized (mapLock) {
      return Optional.ofNullable(resultMap.get(taskName));
    }
  }

  public int currentActiveThreads() {
    return activeTasks.get();
  }
}