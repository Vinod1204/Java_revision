import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static final Semaphore semaphore=new Semaphore(2);

    public static void main(String[] args) {
        for(int i=1;i<=5;i++)
        {
            new Thread(new Task(i)).start();
        }
    }
    static class Task implements Runnable {
    private final int id;
    Task(int id)
    {
        this.id=id;
    }
    @Override
    public void run()
    {
        try {
            System.out.println("Thread "+id+" Waiting for Permit...");
            semaphore.acquire();
            System.out.println("Thread "+id+" Got a permit..");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            System.out.println("Thread"+id+" Releasing Permit...");
            semaphore.release();
        }
    }
        
    }
}
