import java.util.concurrent.*;

class Task implements Runnable
{
    private final String taskname;

    public Task(String name)
    {
        this.taskname=name;
    }
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" Executing Thread "+taskname);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+" completed task "+taskname);
    }
}
public class ThreadPoolExample {
    public static void main(String[] args)
    {
        ExecutorService executor=Executors.newFixedThreadPool(5);

        for(int i=1;i<=5;i++)
        {
            executor.submit(new Task("Task-"+i));
        }

        executor.shutdown();

        try{
            if(!executor.awaitTermination(60, TimeUnit.SECONDS))
            {
                executor.shutdownNow();
            }
        }
        catch(InterruptedException e)
        {
            executor.shutdownNow();
        }
    }
}

