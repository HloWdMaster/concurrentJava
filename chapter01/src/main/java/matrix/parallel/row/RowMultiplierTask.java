package matrix.parallel.row;

/**
 * Create by leonardo on 2019/7/19
 */
public class RowMultiplierTask implements Runnable {

    private final double[][] matrix1;
    private final double[][] matrix2;
    private final double[][] result;

    private final int rows;

    public RowMultiplierTask(double[][] matrix1, double[][] matrix2, double[][] result, int rows) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.rows = rows;
    }

    @Override
    public void run() {
        for (int j = 0; j < rows; j++) {
            result[rows][j] = 0;
            for (int k = 0; k < matrix1[0].length; k++) {
                result[rows][j] += matrix1[rows][k] * matrix2[k][j];
            }
        }
    }
}
