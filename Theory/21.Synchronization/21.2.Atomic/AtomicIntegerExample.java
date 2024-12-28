import java.util.concurrent.atomic.*;

public class AtomicIntegerExample{
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter=new AtomicInteger();

        Thread t1=new Thread(()->{
            for(int i=0;i<5;i++)
            {
                counter.incrementAndGet();
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<5;i++)
            {
                counter.incrementAndGet();
            }
        });
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + counter.get());
    
    }
}