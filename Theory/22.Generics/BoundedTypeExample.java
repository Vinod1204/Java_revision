class Calculator<T extends Number>
{
    public double add(T num1,T num2)
    {
        return num1.doubleValue()+num2.doubleValue();
    }
}
class BoundedTypeExample
{
    public static void main(String[] args) {
        Calculator<Integer> intcalculator=new Calculator<>();
        System.out.println(intcalculator.add(10,25));

        Calculator<Double> doubleCalulator=new Calculator<>();
        System.out.println(doubleCalulator.add(15.2, 20.8));
    }
}

/*
 * You can restrict the types a generic can accept using bounds (extends keyword).
 */