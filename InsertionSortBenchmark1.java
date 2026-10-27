import java.util.Arrays;
import java.util.Random;

public class InsertionSortBenchmark1 {

    // خوارزمية الترتيب بالإدراج
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // قياس زمن الترتيب فقط بالنانو ثانية
    static long measure(int[] original) {
        int[] testArray = Arrays.copyOf(original, original.length); // نسخة مستقلة
        long start = System.nanoTime();
        insertionSort(testArray);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        int n = 100_000;
        Random rand = new Random();

        // السيناريو 1: مصفوفة عشوائية
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++) {
            randomArray[i] = rand.nextInt(1_000_000);
        }

        // السيناريو 2: مصفوفة مرتبة تصاعديًا
        int[] sortedArray = Arrays.copyOf(randomArray, n);
        Arrays.sort(sortedArray);

        long randomTime = measure(randomArray);
        long sortedTime = measure(sortedArray);

        System.out.println("Algorithm: Insertion Sort, N = " + n);
        System.out.printf("Random array : %,d ns%n", randomTime);
        System.out.printf("Sorted array : %,d ns%n", sortedTime);
    }
}