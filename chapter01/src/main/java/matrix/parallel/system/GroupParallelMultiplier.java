package matrix.parallel.system;

import com.sun.rowset.internal.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by leonardo on 2019/7/19
 */
public class GroupParallelMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int lines = matrix1.length; //总行数
        int numThreads = Runtime.getRuntime().availableProcessors();   //核心数
        int step = lines / numThreads;
        int startIndex = 0;
        int endIndex = step;
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new GroupMultiplierTask(matrix1, matrix2, result, startIndex, endIndex));
            thread.start();
            threads.add(thread);
            startIndex = endIndex;
            endIndex = (i == numThreads - 2 ? lines : endIndex + step);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
