import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(ReentrantLockExample::incrementCounter);
        Thread thread2 = new Thread(ReentrantLockExample::incrementCounter);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter);
    }

    public static void incrementCounter() {
        for (int i = 0; i < 5 ; i++) {
            lock.lock();// Acquire the lock
            try {
                counter++; // Critical section
            } finally {
                lock.unlock(); // Release the lock
            }
        }
    }
}
