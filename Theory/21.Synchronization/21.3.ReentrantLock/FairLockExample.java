import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private static final Lock fairLock = new ReentrantLock(true); // Fair lock

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(FairLockExample::performTask, "Thread-" + i).start();
        }
    }

    public static void performTask() {
        try {
            fairLock.lock();
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock.");
        }
    }
}

/*
 * 
 * Thread-0 acquired the lock.
Thread-0 released the lock.
Thread-1 acquired the lock.
Thread-1 released the lock.
Thread-2 acquired the lock.
Thread-2 released the lock.

 */