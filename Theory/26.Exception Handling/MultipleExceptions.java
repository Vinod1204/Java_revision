public class MultipleExceptions {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[3]); // ArrayIndexOutOfBoundsException
            int result = 10 / 0;           // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array issue: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic issue: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
