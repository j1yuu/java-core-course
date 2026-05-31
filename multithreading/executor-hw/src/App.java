import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
        
        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "complete";
        };

        List<Future<String>> results = new ArrayList<>();
        
        try {
            for (int i = 0; i < 10; i++) {
                Future<String> res = service.submit(task);
                results.add(res);          
            }

            for (Future<String> res : results) {
                System.out.println(res.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
