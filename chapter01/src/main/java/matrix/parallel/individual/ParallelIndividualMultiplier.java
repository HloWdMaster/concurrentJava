package matrix.parallel.individual;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by leonardo on 2019/7/19
 */
public class ParallelIndividualMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows = matrix1.length;
        int columns = matrix2[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Thread thread = new Thread(new IndividualMultiplierTask(matrix1, matrix2, result, i, j));
                thread.start();
                threads.add(thread);
                if (threads.size() % 10 == 0) {
                    waitForThreads(threads);
                }
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
