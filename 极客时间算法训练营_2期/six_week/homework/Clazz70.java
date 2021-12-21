package sf.极客时间算法训练营_2期.six_week.homework;

public class Clazz70 {

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] =1;
        dp[1] =1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 4阶 可以从3阶上 也可以从2阶上
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
