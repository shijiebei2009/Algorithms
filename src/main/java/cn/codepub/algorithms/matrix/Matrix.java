package cn.codepub.algorithms.matrix;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/10 20:37
 * </p>
 * <p>
 * ClassName:Matrix
 * </p>
 * <p>
 * Description:方阵的乘法
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Matrix {
    static int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    static int[][] b = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
    static int[][] c = new int[a.length][b.length];

    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < b[j].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        for (int temp[] : c) {
            for (int col : temp) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}