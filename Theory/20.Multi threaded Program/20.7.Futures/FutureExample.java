import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) {
        ExecutorService executor=Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "Task is completed...";
        };

        Future<String> future=executor.submit(task);

        System.out.println("TASk submitted.. Doing other work...");

        try {
            while(!future.isDone())
            {
                System.out.println("Task is still running...");
                Thread.sleep(500);
            }
            String result=future.get();
            System.out.println("Task Result: "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            executor.shutdown();
        }
    }
}

/*
 * 
 * Output:
 * Task submitted. Doing other work...
Task is still running...
Task is still running...
Task is still running...
Task result: Task completed!


Key Methods in Future
Method	Description
get()	-> Retrieves the result, blocking if necessary until the task completes.
get(long timeout, TimeUnit unit) ->	Retrieves the result, with a timeout to avoid indefinite blocking.
isDone() ->	Returns true if the task is completed.
isCancelled()-> Returns true if the task was canceled before completion.
cancel(boolean mayInterrupt) ->	Attempts to cancel the task. If running, the thread may be interrupted.
 */