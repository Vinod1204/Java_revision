import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        // Create a single-threaded executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit multiple tasks to the executor
        for (int i = 1; i <= 5; i++) {
             int taskNumber = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing task: Task-" + taskNumber);
            });
        }

        // Shutdown the executor after submitting all tasks
        executor.shutdown();
    }
}
/*
 * 
 * pool-1-thread-1 is executing task: Task-1
pool-1-thread-1 is executing task: Task-2
pool-1-thread-1 is executing task: Task-3
pool-1-thread-1 is executing task: Task-4
pool-1-thread-1 is executing task: Task-5

Behavior:

Tasks are executed sequentially in the order they are submitted.
 * 
 */