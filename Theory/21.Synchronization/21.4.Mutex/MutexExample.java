import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class MutexExample{
    private static int counter=0;
    private static final Lock mutex=new ReentrantLock();

    public static void main(String[] args) {
        Thread t1=new Thread(MutexExample::incrementCounter);
        Thread t2=new Thread(MutexExample::incrementCounter);

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void incrementCounter()
    {
        for(int i=0;i<5;i++)
        {
            mutex.lock();
            try {
                counter++;
            } finally {
              mutex.unlock();
            }
        }
    }
}