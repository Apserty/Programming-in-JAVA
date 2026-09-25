import java.util.Scanner;
import java.util.ArrayList;

class TaskManager {
    private final ArrayList<String> tasks = new ArrayList<>();
    private int currentSequence = 0;
    private final int totalProcessors;

    public TaskManager(int totalProcessors) {
        this.totalProcessors = totalProcessors;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public synchronized void processTask(int processorId, int taskIndex) {
        while (currentSequence != taskIndex) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        String uppercaseTask = tasks.get(taskIndex).toUpperCase();
        System.out.println("Processor " + processorId + " - Processed: " + uppercaseTask);

        currentSequence++;
        notifyAll();
    }
}

class ProcessorTask implements Runnable {
    private final TaskManager manager;
    private final int processorId;
    private final int taskIndex;

    public ProcessorTask(TaskManager manager, int processorId, int taskIndex) {
        this.manager = manager;
        this.processorId = processorId;
        this.taskIndex = taskIndex;
    }

    @Override
    public void run() {
        manager.processTask(processorId, taskIndex);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> tempTasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    break;
                }
                tempTasks.add(line);
            }
        }

        int m = 2;
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
        }

        if (m < 1 || m > 32) {
            System.out.println("Invalid number of processors. Using 2 processors.");
            m = 2;
        }

        System.out.println("Processing files...");

        TaskManager manager = new TaskManager(m);
        for (String t : tempTasks) {
            manager.addTask(t);
        }

        int totalTasks = manager.getTaskCount();
        Thread[] threads = new Thread[totalTasks];

        for (int i = 0; i < totalTasks; i++) {
            int processorId = (i % m) + 1;
            threads[i] = new Thread(new ProcessorTask(manager, processorId, i));
            threads[i].start();
        }

        for (int i = 0; i < totalTasks; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        scanner.close();
    }
}
