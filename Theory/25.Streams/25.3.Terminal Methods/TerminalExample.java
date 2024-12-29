import java.util.*;
import java.util.stream.*;
public class TerminalExample
{
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3,4,5,6);

        int sum = list.stream().reduce(0,(c,e)-> c+e);
        System.out.println("sum: "+sum);

        List<Integer> doubledNumbers=list.stream().map(n->n*2).collect(Collectors.toList());
        System.out.println("Doubled: " + doubledNumbers);
    }
}