package sf.dp;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-17 09:48
 */
public class 礼物最大价值_二维数组的最大值路径 {
    public static void main(String[] args) {
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = maxValue(a);
    }

    /**
     * dp(i,j)=
     * <p>
     * grid(i,j) i=0，j=0
     * grid(i,j)+dp(i,j−1) i=0
     * grid(i,j)+dp(i−1,j) j=0
     * grid(i,j)+max[dp(i−1,j),dp(i,j−1)]
     * ​
     * <p>
     * 每走一步都有记录，
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0)
                    grid[i][j] += grid[i][j - 1];
                else if (j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 初始第一列和第一行
     */
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }

}
