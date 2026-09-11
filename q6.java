import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Fixed: Use System.in to read standard input stream
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            
            String[] words = input.split(" ");
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < words.length; i++) {
                StringBuilder wordBuilder = new StringBuilder(words[i]);
                result.append(wordBuilder.reverse());
                
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
            
            System.out.println(result.toString());
        }
        
        scanner.close();
    }
}
