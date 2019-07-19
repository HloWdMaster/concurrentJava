package matrix.serial;

/**
 * Create by leonardo on 2019/7/19
 */
public class SerialMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        int rows = matrix1.length;
        int row_col = matrix1[0].length;
        int columns = matrix2[0].length;

//        result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = 0;
                for (int k = 0; k < row_col; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}
