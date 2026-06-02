import java.util.Optional;

import processor.DataProcessor;
import util.ListGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        DataProcessor processor = new DataProcessor();
        int TASKS_COUNT = 100;

        for (int i = 0; i < TASKS_COUNT; i++) {
            processor.insertAndExecuteTask(ListGenerator.generateRandomList());
        }

        while (processor.currentActiveThreads() != 0) {
            Thread.sleep(1);
        }

        for (int i = 0; i < TASKS_COUNT; i++) {
            Optional<Integer> taskRes = processor.getTaskResult("Task " + i);

            if (taskRes.isPresent()) {
                System.out.println("Task " + i + " result: " + taskRes.get());
            } else {
                System.out.println("No result for Task " + i);
            }
        }

        processor.cancel();
    }
}
