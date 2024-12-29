import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.*;    
public class IntermediateExample
{
    public static void main(String[] args) {
        List<String> list=List.of("Alice", "Bob", "Charlie", "Alice");

        list.stream()
        .filter(str -> str.startsWith("A"))
        .distinct()
        .map(s-> s.toUpperCase()) // .map(String::toUpperCase)
        .sorted()
        .forEach(n-> System.out.println(n)); // .foreach(System.out::println)
    }
}

/*
 * Filter ensures only names starting with "A" are processed.
Distinct removes duplicates, leaving a single "Alice".
Map converts "Alice" to "ALICE".
Sorted ensures elements are in order, though it doesn’t matter for one element.
ForEach prints the final result.

 */