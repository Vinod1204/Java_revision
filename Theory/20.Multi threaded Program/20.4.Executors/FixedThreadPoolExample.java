import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing task: " + taskName);
        try {
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " finished task: " + taskName);
    }
}

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            executor.submit(new Task("Task-" + i));
        }

        executor.shutdown(); // Initiates shutdown after all tasks finish
    }
}

/*
 * pool-1-thread-1 is executing task: Task-1
pool-1-thread-2 is executing task: Task-2
pool-1-thread-3 is executing task: Task-3
pool-1-thread-1 finished task: Task-1
pool-1-thread-2 finished task: Task-2
pool-1-thread-3 finished task: Task-3
pool-1-thread-1 is executing task: Task-4
pool-1-thread-2 is executing task: Task-5
...

 */