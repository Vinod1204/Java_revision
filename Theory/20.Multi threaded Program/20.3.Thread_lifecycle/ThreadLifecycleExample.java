class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(2000); // Timed Waiting state
            System.out.println(Thread.currentThread().getName() + " is awake.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " has finished execution.");
    }
}

public class ThreadLifecycleExample {
    public static void main(String[] args) {
        Thread t1 = new MyThread();

        // Thread in NEW state
        System.out.println("Thread state after creation: " + t1.getState()); 

        t1.start(); // Thread enters Runnable state
        System.out.println("Thread state after calling start(): " + t1.getState()); 

        try {
            Thread.sleep(500); // Main thread sleeps to allow t1 to start running
            System.out.println("Thread state during execution: " + t1.getState());

            t1.join(); // Main thread waits for t1 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread enters TERMINATED state
        System.out.println("Thread state after termination: " + t1.getState());
    }
}
