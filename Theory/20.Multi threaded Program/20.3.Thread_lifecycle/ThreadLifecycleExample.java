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


/*
 * Output:
 * 
 *  Thread state after creation: NEW
Thread state after calling start(): RUNNABLE
Thread state during execution: TIMED_WAITING
Thread-0 is running.
Thread-0 is awake.
Thread-0 has finished execution.
Thread state after termination: TERMINATED

State	Description
New	      ->    Thread is created but not started.
Runnable   ->	Thread is ready to run but waiting for CPU time.
Running	    ->  Thread is executing its task.
Blocked     ->	Thread is waiting to acquire a lock.
Waiting     ->	Thread is waiting indefinitely for another thread's signal.
Timed Waiting ->	Thread is waiting for a specific time (e.g., sleep, join with timeout).
Terminated    ->	Thread has completed its task or been stopped explicitly.
 */