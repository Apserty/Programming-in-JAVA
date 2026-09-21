// You are using Java
import java.util.*;
import java.io.*;

class Mian
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        try
        {
            int n = sc.nextInt();
            long fact = factorial(n);
            System.out.println(fact);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Error: Input must be a valid integer.");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            
        }
    }
    
    public static long factorial(int n)
    {
        if(n<0)
        {
            throw new IllegalArgumentException("Error: input must be non-negative");
        }
        
        if(n==0 || n==1)
        {
            return 1;
        }
        
        return n*factorial(n-1);
    }
}
