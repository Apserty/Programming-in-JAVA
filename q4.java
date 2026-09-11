// You are using Java
import java.util.*;
class lab
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        
        StringBuilder sb = new StringBuilder(t);
        
        String rev = sb.reverse().toString();
        
        System.out.println(rev);
    }
}
