public class ExceptionPropagation 
{
    public void method1() throws ArithmeticException
    {
        int result= 10/0;
    }
    public void method2()
    {
        method1();
    }
    public static void main(String[] args) {
        ExceptionPropagation obj=new ExceptionPropagation();
        try {
            obj.method2();
        } catch (ArithmeticException e) {
            System.out.println("Caught in main: "+e.getMessage());
    }
}
}