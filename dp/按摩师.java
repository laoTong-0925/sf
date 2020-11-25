package sf.dp;

/**
 * @Description : dp[i] 以nums[i]为结尾的 最大和 dp[i] = dp[i-2] + nums[i]
 * @Author :
 * @Date: 2020-11-25 09:54
 */
public class 按摩师 {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i]：区间 [0, i] 里接受预约请求的最大时长
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // 今天在选与不选中，选择一个最优的
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    /**
     * 空间优化
     *
     * @param nums
     * @return
     */
    public int massage2(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

}
