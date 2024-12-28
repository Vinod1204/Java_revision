import java.util.concurrent.*;

public class WithVolatileExample
{
    private static volatile int counter=0;
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
                int local_counter=counter;

                while(local_counter<10)
                {
                    if(local_counter!=counter)
                    {
                        System.out.println(" [T1] counter value is changed....");
                        local_counter=counter;
                    }
                }
        });

        Thread t2=new Thread(() -> {
            int local_counter=counter;
            while(local_counter<10)
            {
                System.out.println(" [T2] Increasing counter value by " + (local_counter+1));
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
 * [T2] Increasing counter value by 1
 [T1] counter value is changed....
 [T2] Increasing counter value by 2
 [T1] counter value is changed....
 [T2] Increasing counter value by 3
 [T1] counter value is changed....
 [T2] Increasing counter value by 4
 [T1] counter value is changed....
 [T2] Increasing counter value by 5
 [T1] counter value is changed....
 [T2] Increasing counter value by 6
 [T1] counter value is changed....
 [T2] Increasing counter value by 7
 [T1] counter value is changed....
 [T2] Increasing counter value by 8
 [T1] counter value is changed....
 [T2] Increasing counter value by 9
 [T1] counter value is changed....
 [T2] Increasing counter value by 10
 [T1] counter value is changed....
 */