// Generic class definition
class Box<T> {
    private T value;

    public void setValue(T value) { // Correct method name (setValue with uppercase V)
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// Usage
public class GenericClassExample {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, Generics!"); // Correct method name
        System.out.println(stringBox.getValue());

        Box<Integer> intBox = new Box<>();
        intBox.setValue(123); // Correct method name
        System.out.println(intBox.getValue());
    }
}
