import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) throws Exception {
        final double TAX = 0.06;
        final double INCOME = 172_000;

        CompletableFuture<Double> taxFetch = CompletableFuture.supplyAsync(() -> {
            System.out.println("Started fetching tax...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return TAX;
        }).exceptionally((ex) -> {
            System.err.println("Fetching tax failed: " + ex.getMessage());
            
            return 0.0;
        });

        CompletableFuture<Double> incomeFetch = CompletableFuture.supplyAsync(() -> {
            System.out.println("Started fetching income...");

            try {
                Thread.sleep(654);

                if (true) throw new RuntimeException("Network failed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("fetched income: " + INCOME);
            return INCOME;
        }).exceptionally((ex) -> {
            System.err.println("Fetching income failed: " + ex.getMessage());

            return 0.0;
        });

        CompletableFuture<Double> resultingThread = taxFetch
            .thenCombine(incomeFetch, (tax, income) -> income * (1 - tax))
            .whenComplete((res, ex) -> {
                System.out.println("Resulting income: " + res);
            });

        resultingThread.join();
    }
}
