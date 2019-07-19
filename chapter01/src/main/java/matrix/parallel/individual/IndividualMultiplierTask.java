package matrix.parallel.individual;

import java.io.PipedReader;

/**
 * Create by leonardo on 2019/7/19
 */
public class IndividualMultiplierTask implements Runnable {

    private final double[][] matrix1;
    private final double[][] matrix2;
    private final double[][] result;

    private final int rows;
    private final int columns;

    public IndividualMultiplierTask(double[][] matrix1, double[][] matrix2, double[][] result, int rows, int columns) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public void run() {
        result[rows][columns] = 0;
        for (int i = 0; i < matrix1[0].length; i++) {
            result[rows][columns] += matrix1[rows][i] * matrix2[i][columns];
        }
    }
}
