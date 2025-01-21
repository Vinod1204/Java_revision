import java.io.*;
import java.util.Scanner;
class Star_pattern1
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int num=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=n-i;j++)
            {
                System.out.print("* ");
            }
            int temp=num;
            for(int j=i;j>0;j--)
            {
                System.out.print(temp+" ");
                temp--;
            }
            num+=i+1;
            System.out.println();
        }
        sc.close();
    }
}