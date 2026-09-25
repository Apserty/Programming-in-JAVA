import java.util.Scanner;
class WordPrinter {
    private final String[] words;
    private int currentIndex = 0;
    private int turn = 1;

    public WordPrinter(String sentence) {
        this.words = sentence.split(" ");
    }

    public synchronized void printWord(int threadId) {
        while (currentIndex < words.length) {
            while (turn != threadId && currentIndex < words.length) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (currentIndex < words.length) {
                System.out.println("Thread " + threadId + ": " + words[currentIndex]);
                currentIndex++;
                turn = (threadId == 1) ? 2 : 1;
                notifyAll();
            }
        }
    }
}

class Word1Task implements Runnable {
    private final WordPrinter printer;

    public Word1Task(WordPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printWord(1);
    }
}

class Word2Task implements Runnable {
    private final WordPrinter printer;

    public Word2Task(WordPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printWord(2);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        scanner.close();
        WordPrinter printer = new WordPrinter(sentence);
        Thread thread1 = new Thread(new Word1Task(printer));
        Thread thread2 = new Thread(new Word2Task(printer));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
