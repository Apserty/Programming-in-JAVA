// You are using Java
import java.util.Scanner;

class MessageTask implements Runnable {
    private final String message;

    public MessageTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            
            Thread thread = new Thread(new MessageTask(message));
            thread.start();
            
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        scanner.close();
    }
}
