import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing a task.");
                try {
                    Thread.sleep(500); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
/*
 *
 pool-1-thread-2 is executing a task.
pool-1-thread-4 is executing a task.
pool-1-thread-3 is executing a task.
pool-1-thread-1 is executing a task.
pool-1-thread-5 is executing a task. 
 * 
 * 
 * Behavior:
Threads are created on demand if none are available.
Idle threads are terminated after 60 seconds.
 */
