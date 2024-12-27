import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args)
    {
        Callable<String> callable=new MyCallableTask();

        ExecutorService executors=Executors.newSingleThreadExecutor();
        Future<String> future=executors.submit(callable);

        try {
            String result =future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            executors.shutdown();
        }
}
}
// Callable implementation as a normal class
class MyCallableTask implements Callable<String>
{
    @Override
    public String call() throws Exception
    {
        Thread.sleep(1000);
        return "Callable task result from thread: "+Thread.currentThread().getName();
    }
}

