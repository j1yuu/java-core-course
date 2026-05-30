class Counter {
    private int value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int ITERATIONS_COUNT = 1_000_000;
        int THREADS_COUNT = 3;

        Counter counter = new Counter();

        Runnable innerThread = () -> {
            for (int i = 0; i < ITERATIONS_COUNT; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(innerThread);
        Thread t2 = new Thread(innerThread);
        Thread t3 = new Thread(innerThread);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("EXPECTED: " + ITERATIONS_COUNT * THREADS_COUNT);
        System.out.println("ACTUAL: " + counter.getValue());
    }
}
