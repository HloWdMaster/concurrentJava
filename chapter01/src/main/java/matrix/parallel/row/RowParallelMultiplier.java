package matrix.parallel.row;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by leonardo on 2019/7/19
 */
public class RowParallelMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < matrix1.length; i++) {
            Thread thread = new Thread(new RowMultiplierTask(matrix1, matrix2, result, i));
            thread.start();
            threads.add(thread);
            if (i % 10 == 0) {
                waitForThreads(threads);
            }
        }
    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
