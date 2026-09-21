import java.util.Scanner;

// Custom exception class extending the Exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the integer input representing age
        int age = scanner.nextInt();
        
        try {
            // Check if the age falls outside the valid range
            if (age < 0 || age > 150) {
                throw new InvalidAgeException("Invalid age. Please enter an age between 0 and 150.");
            }
            // If valid, print the success message
            System.out.println("Age is valid!");
            
        } catch (InvalidAgeException e) {
            // Catch the custom exception and print the required error prefix
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
