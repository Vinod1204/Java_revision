import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task1 = () -> System.out.println("Task 1 executed at: " + System.currentTimeMillis());
        Runnable task2 = () -> System.out.println("Task 2 executed at: " + System.currentTimeMillis());

        // Schedule task1 to run after 2 seconds
        scheduler.schedule(task1, 2, TimeUnit.SECONDS);

        // Schedule task2 to run repeatedly every 3 seconds
        scheduler.scheduleAtFixedRate(task2, 1, 3, TimeUnit.SECONDS);

        // Shutdown the scheduler after 10 seconds
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler.");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}

/*
 *
pool-1-thread-1 is executing task: Task-1
pool-1-thread-1 is executing task: Task-2
pool-1-thread-1 is executing task: Task-3
pool-1-thread-1 is executing task: Task-4
pool-1-thread-1 is executing task: Task-5
 
Behavior:

schedule() runs a task once after a delay.
scheduleAtFixedRate() runs a task repeatedly at fixed intervals.
 * 
 */