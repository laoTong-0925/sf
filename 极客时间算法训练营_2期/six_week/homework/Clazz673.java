package sf.极客时间算法训练营_2期.six_week.homework;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
public class Clazz673 {

        public static int findNumberOfLIS(int[] nums) {
            int n = nums.length, maxLen = 0, ans = 0;
            int[] dp = new int[n];
            int[] cnt = new int[n];
            for (int i = 0; i < n; ++i) {
                dp[i] = 1;
                cnt[i] = 1;
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j]; // 重置计数
                        } else if (dp[j] + 1 == dp[i]) {
                            cnt[i] += cnt[j];
                        }
                    }
                }
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                    ans = cnt[i]; // 重置计数
                } else if (dp[i] == maxLen) {
                    ans += cnt[i];
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        int numberOfLIS = findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4,7,2});
        System.out.println(numberOfLIS);
    }
}
