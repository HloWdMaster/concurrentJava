package matrix.parallel.system;

/**
 * Create by leonardo on 2019/7/19
 */
public class GroupMultiplierTask implements Runnable{
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final double[][] result;

    private final int startIndex;
    private final int endIndex;

    public GroupMultiplierTask(double[][] matrix1, double[][] matrix2, double[][] result, int startIndex, int endIndex) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {

        for (int i = startIndex; i < endIndex; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }


}
