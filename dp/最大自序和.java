package sf.dp;

/**
 * @Description : dp[i] 表示nums[i]结尾 的最大子序和
 * @Author :
 * @Date: 2020-11-25 09:36
 */
public class 最大自序和 {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(a);
    }


    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
