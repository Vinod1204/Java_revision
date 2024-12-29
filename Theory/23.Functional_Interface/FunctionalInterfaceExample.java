@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}


public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Lambda expression implementing the calculate method
        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;

        System.out.println("Addition: " + addition.calculate(5, 3));       // Output: 8
        System.out.println("Multiplication: " + multiplication.calculate(5, 3)); // Output: 15
    }
}
