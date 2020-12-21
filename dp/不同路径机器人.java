package sf.dp;

/**
 * @Description : 左上到右下
 * <p>
 * dp[i][j] 是到达 i, j 最多路径
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * @Author :
 * @Date: 2020-12-09 09:25
 */
public class 不同路径机器人 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++)// 上和左都是1
            dp[0][i] = 1;
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
