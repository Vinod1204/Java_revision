import java.util.concurrent.*;

public class WithoutVolatileExample
{
    private static  int counter=0;
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
                int local_counter=counter;

                while(local_counter<10)
                {
                    if(local_counter!=counter)
                    {
                        System.out.println(" T1 counter value is changed....");
                        local_counter=counter;
                    }
                }
        });

        Thread t2=new Thread(() -> {
            int local_counter=counter;
            while(local_counter<10)
            {
                System.out.println(" Increasing counter value " + (local_counter+1));
                counter=++local_counter;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }
}

/*
 * Output
 *  Increasing counter value 1
 Increasing counter value 2
 Increasing counter value 3
 Increasing counter value 4
 Increasing counter value 5
 Increasing counter value 6
 Increasing counter value 7
 Increasing counter value 8
 Increasing counter value 9
 Increasing counter value 10
 */