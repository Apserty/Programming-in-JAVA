// You are using Java
// You are using Java
import java.util.*;
import java.io.*;

class InvalidEmailException extends Exception
{
    public InvalidEmailException(String message)
    {
        super(message);
    }
}



class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine().trim();
        
        try
        {
            validateEmail(email);
            System.out.println("Email address is valid!");
        }
        catch(InvalidEmailException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        finally
        {
            
        }
    }
    
    public static void validateEmail(String email) throws InvalidEmailException
    {
        int len = email.length();
        
        int firstat = email.indexOf('@');
        int lastat = email.lastIndexOf('@');
        
        if(firstat == -1 || firstat != lastat || email.startsWith("@") || (email.endsWith("@")))
        {
            throw new InvalidEmailException("Invalid email format.");
        }
        
        if(email.startsWith(".") || email.endsWith("."))
        {
            throw new InvalidEmailException("Invalid email format.");
        }
        
        int firstDotAfterAt = email.indexOf('.', firstat);
        int lastDotAfterAt = email.lastIndexOf('.');

        // Ensure there is at least one dot after '@' and exactly one dot after '@'
        if (firstDotAfterAt == -1 || firstDotAfterAt != lastDotAfterAt) {
            throw new InvalidEmailException("Invalid email format.");
        }

        // Additional check: Ensure '.' is not immediately adjacent to '@'
        if (firstDotAfterAt == firstat + 1) {
            throw new InvalidEmailException("Invalid email format.");
        }

        // Extract domain extension (part after the last dot)
        String domain = email.substring(lastDotAfterAt + 1);

        // Validate domain extension
        if (!domain.equals("in") && !domain.equals("com") && !domain.equals("net") && !domain.equals("biz")) {
            throw new InvalidEmailException("Invalid email format.");
        }
    }
}
