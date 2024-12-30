public class ThrowExample{
    public void validage(int age) throws Exception{
        if(age<18)
        {
            throw new Exception("Age is less than 18");
        }
    }
    public static void main(String[] args) {
        ThrowExample obj=new ThrowExample();
        try{
            obj.validage(15);
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}