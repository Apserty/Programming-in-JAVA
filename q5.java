// You are using Java
import java.util.*;
import java.io.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        try
        {
            String line = sc.nextLine().trim();
            
            String[] tokens = line.split("\\s+");
            
            int sum =0;
            int count =0;
            
            for(String token : tokens)
            {
                try
                {
                    int value = Integer.parseInt(token);
                    
                    if(value < 0)
                    {
                        throw new IllegalArgumentException("Error: Negative numbers are not allowed.");
                        
                    }
                    
                    sum += value;
                    count++;
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Warning: Ignoring non-integer value '"+ token +"'");
                }
            }
            if(count>0)
            {
                double avg = (double) sum / count;
                System.out.printf("%.2f\n",avg);
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            
        }
        
    }
}
