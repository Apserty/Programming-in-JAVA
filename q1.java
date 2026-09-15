// You are using Java
import java.util.*;
import java.io.*;

class InvalidUsernameException extends Exception
{
    public InvalidUsernameException(String message)
    {
        super(message);
    }
}

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        String n = sc.nextLine();
        
        try 
        {
            validateUsername(n);
            System.out.println("Username is Valid: " + n);
        }
        catch(InvalidUsernameException e)
        {
            System.out.println("Invalid Username: "+ e.getMessage());
        }
    }
    
    public static void validateUsername(String n) throws InvalidUsernameException
    {
        if(n.length() < 5)
        {
            throw new InvalidUsernameException("Username must be at least 5 characters long");
        }
        
        if(n.contains(" "))
        {
            throw new InvalidUsernameException("Username cannot contain spaces");
        }
    }
}
