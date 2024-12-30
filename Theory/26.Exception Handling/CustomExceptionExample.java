class CustomException extends Exception{
    public CustomException(String meassage)
    {
        super(meassage);
    }
}
public class CustomExceptionExample {
public static void main(String[] args) {
    try{
        throw new CustomException("This is a custom exception..");
    }
    catch(CustomException e)
    {
        System.out.println("Caught: "+e.getMessage());
    }
}
}
