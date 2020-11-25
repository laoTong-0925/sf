package sf.dp;

import java.util.Arrays;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-24 09:42
 */
public class 最长上升子序列 {
    public static void main(String[] args) {
        String s = "dsa";
        byte[] bytes = s.getBytes();
    }

    // Dynamic programming.
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
