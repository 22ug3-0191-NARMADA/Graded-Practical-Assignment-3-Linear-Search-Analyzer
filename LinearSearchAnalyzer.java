import java.util.Random;

public class LinearSearchAnalyzer {

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int[] generateRandomArray(int size, int bound) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(bound);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        int bound = 10000;
        int searchKey = 5000;
        int runs = 5; // number of times to run for averaging

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Average Time (ms)");
        System.out.println("-------------------------------");

        for (int size : sizes) {
            int[] array = generateRandomArray(size, bound);
            double totalTime = 0;

            for (int i = 0; i < runs; i++) {
                long startTime = System.nanoTime();
                linearSearch(array, searchKey);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime) / 1_000_000.0;
            }

            double averageTime = totalTime / runs;
            System.out.printf("%d | %.5f\n", size, averageTime);
        }
    }
}