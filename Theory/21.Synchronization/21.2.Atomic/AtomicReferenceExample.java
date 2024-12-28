import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
    public static void main(String[] args) {
        // Create an AtomicReference with an initial value
        AtomicReference<String> sharedString = new AtomicReference<>("Initial");

        // Thread 1: Attempt to update the value
        Thread t1 = new Thread(() -> {
            boolean success = sharedString.compareAndSet("Initial", "Updated by Thread 1");
            System.out.println("Thread 1 Update Success: " + success);
        });

        // Thread 2: Attempt to update the value
        Thread t2 = new Thread(() -> {
            boolean success = sharedString.compareAndSet("Initial", "Updated by Thread 2");
            System.out.println("Thread 2 Update Success: " + success);
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final value
        System.out.println("Final Value: " + sharedString.get());
    }
}
