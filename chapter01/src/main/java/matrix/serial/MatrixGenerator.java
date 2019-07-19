package matrix.serial;

import java.util.Random;

/**
 * Create by leonardo on 2019/7/19
 */
public class MatrixGenerator {

    public static double[][] gengerate(int rows ,int columns) {
        double[][] matrix = new double[rows][columns];
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = r.nextDouble() * 10;
            }
        }
        return matrix;
    }
}
