import java.util.Scanner;

class TemperatureSensor implements Runnable {
    private final int lower;
    private final int upper;

    public TemperatureSensor(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public void run() {
        for (int i = lower; i <= upper; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String buildingName = scanner.nextLine();
            int L = scanner.nextInt();
            int U = scanner.nextInt();

            System.out.println("Name - " + buildingName);

            TemperatureSensor sensor = new TemperatureSensor(L, U);
            Thread sensorThread = new Thread(sensor);
            sensorThread.start();

            try {
                sensorThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        scanner.close();
    }
}
