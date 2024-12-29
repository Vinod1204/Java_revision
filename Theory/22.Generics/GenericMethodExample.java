public class GenericMethodExample
{
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"A", "B", "C"};

        printArray(intArray);    
        printArray(stringArray); 
    }

    public static <T> void printArray(T[] array)
    {
        for(T element:array)
        {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}