package matrix.serial;

import java.util.Date;

/**
 * Create by leonardo on 2019/7/19
 */
public class SerialMain {

    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.gengerate(200, 300);
        double[][] matrix2 = MatrixGenerator.gengerate(300, 5000);
        double[][] result = new double[matrix1.length][matrix2[0].length];
        Date start = new Date();
        SerialMultiplier.multiply(matrix1,matrix2,result);
        Date end = new Date();
        System.out.printf("Serial :%d%n",end.getTime()-start.getTime());

    }
}
