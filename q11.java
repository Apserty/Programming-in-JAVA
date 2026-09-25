import java.util.Scanner;
class SortWorker implements Runnable {
    private final int[] arr;
    private final int left;
    private final int right;

    public SortWorker(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    @Override
    public void run() {
        mergeSort(arr, left, right);
    }
}

class MultiThreadedMergeSort {
    private static void mergeParts(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void multiThreadedMergeSort(int[] array) {
        int n = array.length;
        int numParts = Math.min(4, n);
        if (numParts < 2) {
            numParts = 2;
        }

        Thread[] threads = new Thread[numParts];
        int[] leftBounds = new int[numParts];
        int[] rightBounds = new int[numParts];
        
        int size = n / numParts;
        int remainder = n % numParts;

        int currentLeft = 0;
        for (int i = 0; i < numParts; i++) {
            int currentRight = currentLeft + size - 1;
            if (remainder > 0) {
                currentRight++;
                remainder--;
            }
            leftBounds[i] = currentLeft;
            rightBounds[i] = currentRight;
            threads[i] = new Thread(new SortWorker(array, currentLeft, currentRight));
            threads[i].start();
            currentLeft = currentRight + 1;
        }

        for (int i = 0; i < numParts; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (int i = 1; i < numParts; i++) {
            mergeParts(array, 0, rightBounds[i - 1], rightBounds[i]);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = sc.nextInt();
        sc.close();
        MultiThreadedMergeSort.multiThreadedMergeSort(array);
        System.out.println("Sorted Array:");
        for (int num : array) System.out.print(num + " ");
    }
}

