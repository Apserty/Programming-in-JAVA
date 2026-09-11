import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String originalString = scanner.nextLine();
            
            // Convert to lowercase to make the check case-insensitive
            String lowerCaseString = originalString.toLowerCase();
            
            // Use StringBuilder to reverse the string
            StringBuilder sb = new StringBuilder(lowerCaseString);
            String reversedString = sb.reverse().toString();
            
            // Verify if the lowercase version matches its reversed counterpart
            if (lowerCaseString.equals(reversedString)) {
                System.out.println(originalString + " is a palindrome");
            } else {
                System.out.println(originalString + " is not a palindrome");
            }
        }
        
        scanner.close();
    }
}
