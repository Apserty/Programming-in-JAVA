import java.util.Scanner;

class Inventory {
    private int stock;
    private int currentSequence = 0;

    public Inventory(int initialStock) {
        this.stock = initialStock;
    }

    public synchronized void processOrder(String customerName, int quantity, int targetSequence) {
        while (currentSequence != targetSequence) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        if (stock >= quantity) {
            stock -= quantity;
            System.out.println(customerName + " successfully ordered " + quantity + " items.");
        } else {
            System.out.println(customerName + " failed to order " + quantity + " items. Insufficient stock!");
        }

        currentSequence++;
        notifyAll();
    }

    public synchronized int getStock() {
        return stock;
    }
}

class OrderTask implements Runnable {
    private final Inventory inventory;
    private final String customerName;
    private final int quantity;
    private final int sequenceId;

    public OrderTask(Inventory inventory, String customerName, int quantity, int sequenceId) {
        this.inventory = inventory;
        this.customerName = customerName;
        this.quantity = quantity;
        this.sequenceId = sequenceId;
    }

    @Override
    public void run() {
        inventory.processOrder(customerName, quantity, sequenceId);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int initialStock = scanner.nextInt();
            int n = scanner.nextInt();

            String[] names = new String[n];
            int[] quantities = new int[n];

            for (int i = 0; i < n; i++) {
                names[i] = scanner.next();
                quantities[i] = scanner.nextInt();
            }

            Inventory inventory = new Inventory(initialStock);
            Thread[] threads = new Thread[n];

            for (int i = 0; i < n; i++) {
                threads[i] = new Thread(new OrderTask(inventory, names[i], quantities[i], i));
                threads[i].start();
            }

            for (int i = 0; i < n; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Final stock: " + inventory.getStock());
        }
        scanner.close();
    }
}
