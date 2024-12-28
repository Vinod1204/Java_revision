import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(TryLockExample::performTask);
        Thread thread2 = new Thread(TryLockExample::performTask);

        thread1.start();
        thread2.start();
    }

    public static void performTask() {
        try {
            if (lock.tryLock()) { // Attempt to acquire the lock
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                    Thread.sleep(1000); // Simulate work
                } finally {
                    lock.unlock(); // Release the lock
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Thread-0 acquired the lock.
Thread-1 could not acquire the lock.

 */