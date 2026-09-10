
import java.util.*;
class ans
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        StringBuilder uniqueChars = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (uniqueChars.indexOf(String.valueOf(ch)) == -1) {
                    uniqueChars.append(ch);
                }
            }
             System.out.println(uniqueChars.toString());
    }
}
