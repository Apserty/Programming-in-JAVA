// You are using Java
import java.util.*;
class lab
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String t =  sc.nextLine();
        char ch = sc.next().charAt(0);
        
        StringBuilder sb = new StringBuilder(t);
        int count =0;
        
        for (int i = 0; i < t.length(); i++)
        {
            if (t.charAt(i) == ch) 
            {
                count++;
            }
        }    
            
            System.out.printf("The character '%s' occurs %d times.",ch,count);
    }
}
