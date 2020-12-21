package sf.dp;

/**
 * @Description :
 * @Author :
 * @Date: 2020-10-12 10:44
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(up(6));
    }

    /**
     * 会超时
     */
    public static int up(int n) {
        if (n < 2)
            return 1;
        if (n < 4)
            return n;
        return up(n - 1) + up(n - 2);
    }

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 根据规律得出：0 1 2 3 4 5 6 答案分别是 1 1 2 3 5 8 13 发布是前前两位相加，更具规律得出
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
