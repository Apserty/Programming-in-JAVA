import java.util.Scanner;

// You are using Java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidator {
    public void handleValidation() {
        Scanner scanner = new Scanner(System.in);
        try {
            int age = scanner.nextInt();
            validate(age);
            System.out.println("Eligible to vote");
        } catch (InvalidAgeException e) {
            System.out.println("Exception occurred: InvalidAgeException: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("An error occured: " + e.getClass().getName());
        } catch (Exception e) {
            System.out.println("An error occured: " + e.getClass().getName());
        } finally {
            scanner.close();
        }
    }

    public void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is not valid to vote");
        }
    }
}

class Main {
    public static void main(String args[]) {
        AgeValidator ageValidator = new AgeValidator();
        ageValidator.handleValidation();
    }
}
