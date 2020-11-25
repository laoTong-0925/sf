package sf.剑指.简单;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-06 10:06
 */
public class 剪绳子 {
    public static void main(String[] args) {
        int i = cuttingRope(10);
        System.out.println(i);
        int i1 = cuttingRope2(3);
    }

    /**
     * DP
     */
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    /**
     * 递归
     */
    public static int cuttingRope2(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cuttingRope2(n - i)));
        }
        return res;
    }

    /**
     * 递归记忆
     */
    public static int cuttingRope3(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        int res = 0;
        for (int i = 3; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cuttingRope3(n - i)));
        }
        return res;
    }

    /**
     * 规律
     */
    public int cuttingRope1(int n) {
        //1.创建数组-设置对应的含义,dp[n]为长度为 n 时候，最大的乘积 我们只需求出dp[n]
        int[] dp = new int[n + 7];
        //3.确定初始值
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        if (n <= 6) {
            return dp[n];
        }
        //2.找到递推关系
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 3] * 3;
        }
        return dp[n];
    }
}
