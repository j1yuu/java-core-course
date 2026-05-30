import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}

class VolatileCounter {
    private volatile int value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}

class SynchronizedCounter {
    private int value = 0;

    public synchronized void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}

class AtomicCounter {
    private AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        value.incrementAndGet();
    }

    public int getValue() {
        return value.get();
    }
}

public class App {
    private static final int THREADS_COUNT = 9;
    private static final int ITERATIONS_COUNT = 1_000_000;

    public static void main(String[] args) throws Exception {
        notWorkingCase();
        volatileExample();
        synchronizedExample();
        atomicExample();
        reentrantLockExample();
    }

    public static void notWorkingCase() {
        Counter counter = new Counter();

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS_COUNT; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("NOT WORKING: " + counter.getValue());
    }

    public static void volatileExample() {
        VolatileCounter counter = new VolatileCounter();

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS_COUNT; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("VOLATILE EXAMPLE: " + counter.getValue());
    }

    public static void synchronizedExample() {
        SynchronizedCounter counter = new SynchronizedCounter();

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS_COUNT; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("SYNCHRONIZED EXAMPLE: " + counter.getValue());
    }

    public static void atomicExample() {
        AtomicCounter counter = new AtomicCounter();

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS_COUNT; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ATOMIC EXAMPLE: " + counter.getValue());
    }

    public static void reentrantLockExample() {
        Counter counter = new Counter();
        ReentrantLock lock = new ReentrantLock();

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS_COUNT; j++) {
                    lock.lock();
                    try {
                        counter.increment();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("REENTRANTLOCK EXAMPLE: " + counter.getValue());
    }
}
