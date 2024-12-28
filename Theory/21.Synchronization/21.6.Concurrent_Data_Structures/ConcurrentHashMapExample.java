import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample{
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> map=new ConcurrentHashMap<>();
        map.put(1,"A");
        map.put(2, "B");
        Thread t1=new Thread(() -> map.put(3, "C"));
        Thread t2=new Thread(() -> map.put(4,"D"));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConcurrentHashMap : "+map);
    }
}