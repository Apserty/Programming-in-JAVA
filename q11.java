import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input strings safely even if they contain empty lines
        String username = scanner.hasNextLine() ? scanner.nextLine() : "";
        String password = scanner.hasNextLine() ? scanner.nextLine() : "";
        String mobile = scanner.hasNextLine() ? scanner.nextLine() : "";
        
        // 1. Username Validation Block
        try {
            if (username.length() < 4 || username.length() > 20) {
                throw new IllegalArgumentException("Error - Invalid username length");
            }
            System.out.println("Username: " + username);
        } catch (IllegalArgumentException e) {
            System.out.println("Username: " + e.getMessage());
        }

        // 2. Password Validation Block
        try {
            boolean hasUppercase = false;
            boolean hasDigit = false;
            
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                }
            }
            
            if (password.length() < 8 || !hasUppercase || !hasDigit) {
                throw new IllegalArgumentException("Error - Must be at least 8 chars, include uppercase and digit");
            }
            System.out.println("Password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println("Password: " + e.getMessage());
        }

        // 3. Mobile Number Validation Block
        try {
            // Check for non-digits manually to throw NumberFormatException as explicitly requested
            for (int i = 0; i < mobile.length(); i++) {
                if (!Character.isDigit(mobile.charAt(i))) {
                    throw new NumberFormatException("Error - Invalid mobile number");
                }
            }
            
            // Check structural rules: exactly 10 digits and starts with 6, 7, 8, or 9
            if (mobile.length() != 10) {
                throw new IllegalArgumentException("Error - Invalid mobile number");
            }
            char firstChar = mobile.charAt(0);
            if (firstChar < '6' || firstChar > '9') {
                throw new IllegalArgumentException("Error - Invalid mobile number");
            }
            
            System.out.println("Mobile: " + mobile);
        } catch (NumberFormatException e) {
            System.out.println("Mobile: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Mobile: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
