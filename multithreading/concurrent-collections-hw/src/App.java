import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        // List<String> unsafeList = new ArrayList<>();
        List<String> safeList = new CopyOnWriteArrayList<>();

        Runnable writer = () -> {
            for (int i = 0; i < 10_000; i++) {
                // unsafeList.add("Item " + i);
                safeList.add("Item " + i);
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 100_000; i++) {
                try {
                    // for (String item : unsafeList) {
                    for (String item : safeList) {
                        if (item == null) {
                            System.out.println("null found");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Reader error: " + e);
                }
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(writer);
        service.execute(writer);
        service.execute(writer);

        service.execute(reader);
        service.execute(reader);
        service.execute(reader);

        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);

        // System.out.println("Final size: " + unsafeList.size());
        System.out.println("Final size: " + safeList.size());
    }
}