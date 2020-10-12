package sf;

/**
 * @ClassName : 旋转矩阵
 * @Description :
 * @Author :
 * @Date: 2020-08-10 10:39
 */
public class 旋转矩阵 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2},
                {3, 4, 5, 6}
        };
//        rotate2(matrix);
        rotate3(matrix);
    }

    /**
     * 思路：
     * 将matrix分为一圈一圈的小圈
     * 顺时针旋转其实就是每圈中各个元素依次占位
     *
     * @param matrix
     */
    private static void rotate2(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * @param matrix
     * @param tR     : 左上row坐标 行
     * @param tC     : 左上col坐标 列
     * @param dR     : 右下row坐标
     * @param dC     : 右下col坐标
     */
    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        // 总共需要调换的次数
        int total = dC - tC;
        int temp = 0;
        for (int i = 0; i < total; i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            sout(matrix);
            matrix[dR - i][tC] = matrix[dR][dC - i];
            sout(matrix);
            matrix[dR][dC - i] = matrix[tR + i][dC];
            sout(matrix);
            matrix[tR + i][dC] = temp;
            sout(matrix);
        }
    }

    private static void sout(int[][] matrix){
        for (int[] is : matrix) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void rotate3(int[][] matrix) {
        int x = matrix[0].length - 1;
        int y = matrix.length - 1;
        //第一步，对角线对称
        for (int i = 0; i <= y; i ++) {
            for (int j = 0; j <= x; j ++) {
                //这里的规律可以画出来，在纸上找一下
                int t = matrix[i][j];
                matrix[i][j] = matrix[y - j][x];
                matrix[y - j][x] = t;
            }
            x --;
        }
        sout(matrix);
        //第二步，上下对称
        x = matrix[0].length - 1;
        for (int i = 0; i <= y/2; i ++) {
            for (int j = 0; j <= x; j ++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[y - i][j];
                matrix[y - i][j] = t;
            }
        }
        sout(matrix);
    }


}
