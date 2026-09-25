import java.util.Scanner;

class SharedBuffer {
    private int data;
    private boolean isEmpty = true;

    public synchronized void produce(int value) {
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        data = value;
        isEmpty = false;
        System.out.println("Produced: " + data);
        notifyAll();
    }

    public synchronized void consume() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("Consumed: " + data);
        isEmpty = true;
        notifyAll();
    }
}

class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final int limit;

    public Producer(SharedBuffer buffer, int limit) {
        this.buffer = buffer;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            buffer.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private final SharedBuffer buffer;
    private final int limit;

    public Consumer(SharedBuffer buffer, int limit) {
        this.buffer = buffer;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            buffer.consume();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            SharedBuffer buffer = new SharedBuffer();
            Thread producerThread = new Thread(new Producer(buffer, n));
            Thread consumerThread = new Thread(new Consumer(buffer, n));

            producerThread.start();
            consumerThread.start();

            try {
                producerThread.join();
                consumerThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        scanner.close();
    }
}
