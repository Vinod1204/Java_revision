import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample
{
    public static void main(String[] args) {
        List<Integer> numbers=IntStream.range(1,11).boxed().collect(Collectors.toList());

        numbers.parallelStream().map(n -> n*2).forEach(n-> System.out.println(n)); 
    }
}