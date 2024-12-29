import java.util.Comparator;

public class LambdaExample{
    public static void main(String[] args) {
        Comparator<Integer> comparator1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2)
            {
                return o1-o2;
            }
        };
        System.out.println(comparator1.compare(15,10));

        Comparator<Integer> comparator2= (o1,o2) -> o1*o2;

        System.out.println(comparator2.compare(15, 10));
    }
}