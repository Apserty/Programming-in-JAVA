// You are using Java
import java.util.*;
import java.io.*;

class InvalidAgeException extends Exception
{
    public InvalidAgeException(String message)
    {
        super(message);
    }
}

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        
        try
        {
            int age = sc.nextInt();
            if(age < 18)
        {
            throw new InvalidAgeException("Exception occurred: InvalidAgeException: Age is not valid to vote");
        }
            
            System.out.println("Eligible to vote");
        }
        catch(InvalidAgeException e)
        {
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println("An error occurred: "+e.getClass().getName());
        }
    }
    
}
