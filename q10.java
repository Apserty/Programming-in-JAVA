import java.util.Scanner;

class BankAccount {
    private int balance = 100;
    private int currentSequence = 0;

    public synchronized void processTransaction(int amount, int targetSequence) {
        while (currentSequence != targetSequence) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        if (amount < 0) {
            int withdrawAmount = Math.abs(amount);
            if (balance >= withdrawAmount) {
                balance -= withdrawAmount;
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            balance += amount;
        }

        currentSequence++;
        notifyAll();
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class TransactionTask implements Runnable {
    private final BankAccount account;
    private final int amount;
    private final int sequenceId;

    public TransactionTask(BankAccount account, int amount, int sequenceId) {
        this.account = account;
        this.amount = amount;
        this.sequenceId = sequenceId;
    }

    @Override
    public void run() {
        account.processTransaction(amount, sequenceId);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] transactions = new int[n];
            for (int i = 0; i < n; i++) {
                transactions[i] = scanner.nextInt();
            }

            BankAccount account = new BankAccount();
            Thread[] threads = new Thread[n];

            for (int i = 0; i < n; i++) {
                threads[i] = new Thread(new TransactionTask(account, transactions[i], i));
                threads[i].start();
            }

            for (int i = 0; i < n; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Final balance: " + account.getBalance());
        }
        scanner.close();
    }
}
