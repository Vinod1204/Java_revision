public class SleepExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                System.out.println("Thread is going to sleep");
                Thread.sleep(2000); // Sleep for 2 seconds
                System.out.println("Thread woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
    }
}
