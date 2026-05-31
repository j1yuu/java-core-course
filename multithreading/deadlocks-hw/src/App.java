public class App {
    public static void main(String[] args) throws Exception {
        deadlockSolved();
    }

    public static void deadlock() {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                for (int i = 0; i < 1_000; i++) {
                    synchronized (lockB) {
                        System.out.println("THREAD 1: " + i);
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                for (int i = 0; i < 1_000; i++) {
                    synchronized (lockA) {
                        System.out.println("THREAD 2: " + i);
                    }
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deadlockSolved() {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                for (int i = 0; i < 1_000; i++) {
                    synchronized (lockB) {
                        System.out.println("THREAD 1: " + i);
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockA) {
                for (int i = 0; i < 1_000; i++) {
                    synchronized (lockB) {
                        System.out.println("THREAD 2: " + i);
                    }
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
