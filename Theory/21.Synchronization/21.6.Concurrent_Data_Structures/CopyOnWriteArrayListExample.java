
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample{
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        Thread t1=new Thread(() -> list.add("C"));
        Thread t2=new Thread(() -> list.add("D"));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConcurrentHashMap : "+list);
    }
}