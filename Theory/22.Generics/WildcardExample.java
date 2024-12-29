
/*
 * 
 * Wildcards (?) provide flexibility in using generics when the exact type is unknown.
Unbounded Wildcard (<?>): Any type.
Upper-Bounded Wildcard (<? extends Type>): Any type that is a subtype of Type.
Lower-Bounded Wildcard (<? super Type>): Any type that is a supertype of Type.
 */

import java.util.List;

public class WildcardExample {
 public static void main(String[] args) {
    List<Integer> Intlist=List.of(1,2,3);
    printList(Intlist);

    List<String> stringlist=List.of("A","B","C");
    printList(stringlist);
 }
 public static void printList(List<?> list)
 {
    for(Object obj:list)
    {
        System.out.println(obj+" ");
    }
    System.out.println();
 }
 }