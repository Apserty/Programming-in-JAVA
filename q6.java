// You are using Java
import java.util.*;
import java.io.*;

class DotException extends Exception
{
    public DotException(String message)
    {
        super(message);
    }
}

class AtTheRateException extends Exception
{
    public AtTheRateException(String message)
    {
        super(message);
    }
}

class DomainException extends Exception
{
    public DomainException(String message)
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
            System.out.println("Valid email address");
        }
        catch(DotException e)
        {
            System.out.println("DotException: " + e.getMessage());
            System.out.println("Invalid email address");
        }
        catch(DomainException e)
        {
            System.out.println("DomainException: "+e.getMessage());
            System.out.println("Invalid email address");
        }
        catch(AtTheRateException e)
        {
            System.out.println("AtTheRateException: "+e.getMessage());
            System.out.println("Invalid email address");
        }
        finally
        {
            
        }
    }
    
    public static void validateEmail(String email) throws DotException, AtTheRateException, DomainException
    {
        int len = email.length();
        
        int firstat = email.indexOf('@');
        int lastat = email.lastIndexOf('@');
        
        if(firstat == -1 || firstat != lastat || email.startsWith("@") || (email.endsWith("@")))
        {
            throw new AtTheRateException("Invalid @ usage");
        }
        
        if(email.startsWith(".") || email.endsWith("."))
        {
            throw new DotException("Invalid Dot usage");
        }
        
        int firstDotAfterAt = email.indexOf('.', firstat);
        int lastDotAfterAt = email.lastIndexOf('.');

        // Ensure there is at least one dot after '@' and exactly one dot after '@'
        if (firstDotAfterAt == -1 || firstDotAfterAt != lastDotAfterAt) {
            throw new DotException("Invalid Dot usage");
        }

        // Additional check: Ensure '.' is not immediately adjacent to '@'
        if (firstDotAfterAt == firstat + 1) {
            throw new DotException("Invalid Dot usage");
        }

        // Extract domain extension (part after the last dot)
        String domain = email.substring(lastDotAfterAt + 1);

        // Validate domain extension
        if (!domain.equals("in") && !domain.equals("com") && !domain.equals("net") && !domain.equals("biz")) {
            throw new DomainException("Invalid Domain");
        }
    }
}
