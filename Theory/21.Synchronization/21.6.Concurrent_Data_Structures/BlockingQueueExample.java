import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample
{
 public static void main(String[] args)
 {
    BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(3);
    Thread producer=new Thread(()->{
        try {
            for(int i=1;i<=5;i++)
            {
                System.out.println("Producing : "+i);
                queue.put(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    Thread consumer=new Thread(()->{
        try {
            for(int i=1;i<=5;i++)
            {
                System.out.println("Consuming : "+queue.take());
                queue.put(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    producer.start();
    consumer.start();
    System.out.println(queue);
 }
}