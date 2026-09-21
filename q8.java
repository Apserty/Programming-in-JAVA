import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double weight = null;
        Double height = null;
        Integer duration = null;

        // Validation for Weight
        try {
            if (!scanner.hasNextLine()) throw new IllegalArgumentException();
            String line = scanner.nextLine().trim();
            double val = Double.parseDouble(line);
            if (val <= 0 || val > 300) {
                throw new IllegalArgumentException();
            }
            weight = val;
            System.out.println("Weight: " + line);
        } catch (Exception e) {
            System.out.println("Weight: Error - Invalid weight value");
        }

        // Validation for Height
        try {
            if (!scanner.hasNextLine()) throw new IllegalArgumentException();
            String line = scanner.nextLine().trim();
            double val = Double.parseDouble(line);
            if (val <= 0 || val > 2.5) {
                throw new IllegalArgumentException();
            }
            height = val;
            System.out.println("Height: " + line);
        } catch (Exception e) {
            System.out.println("Height: Error - Invalid height value");
        }

        // Validation for Workout Duration
        try {
            if (!scanner.hasNextLine()) throw new IllegalArgumentException();
            String line = scanner.nextLine().trim();
            int val = Integer.parseInt(line);
            if (val < 1 || val > 300) {
                throw new IllegalArgumentException();
            }
            duration = val;
            System.out.println("Workout Duration: " + val);
        } catch (Exception e) {
            System.out.println("Workout Duration: Error - Invalid workout duration");
        }

        // BMI Calculation (only if both weight and height are valid)
        if (weight != null && height != null) {
            double bmi = weight / (height * height);
            System.out.printf("BMI: %.2f\n", bmi);
        }

        scanner.close();
    }
}
