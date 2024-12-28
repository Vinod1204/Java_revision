import java.util.concurrent.atomic.*;

public class AtomicBooleanExample{
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean counter=new AtomicBoolean(false);

        Thread t1=new Thread(()->{
            if(counter.compareAndSet(false, true))
            {
                System.out.println("T1 is set to true");
            }
            else{
                System.out.println("T1 is already true");
            }
        });
        Thread t2=new Thread(()->{
            if(counter.compareAndSet(false, true))
            {
                System.out.println("T2 is set to true");
            }
            else{
                System.out.println("T2 is already true");
            }
        });
        
        t1.start();
        t2.start();
    
    }
}