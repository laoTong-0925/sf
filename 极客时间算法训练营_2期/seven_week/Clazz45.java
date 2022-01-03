package sf.极客时间算法训练营_2期.seven_week;

public class Clazz45 {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; //dp[i]表示跳到i的最小次数
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) { //遍历所有可以跳一次就到达的上一个位置
                if (nums[j] >= i - j) ans = Math.min(ans, dp[j] + 1);
            }
            dp[i] = ans;
        }
        return dp[n - 1];
    }

}
