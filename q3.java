import java.util.Scanner;

// Custom exception class
class InvalidDurationException extends Exception {
    public InvalidDurationException(String message) {
        super(message);
    }
}

public class Main {

    // Method to validate the meeting duration
    public static void validateMeetingDuration(int n) throws InvalidDurationException {
        if (n <= 0 || n > 240) {
            throw new InvalidDurationException("Error: Invalid meeting duration. Please enter a positive integer not exceeding 240 minutes (4 hours).");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            int n = scanner.nextInt();
            validateMeetingDuration(n);
            System.out.println("Meeting scheduled successfully!");
        } catch (InvalidDurationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid meeting duration. Please enter a positive integer not exceeding 240 minutes (4 hours).");
        } finally {
            scanner.close();
        }
    }
}
