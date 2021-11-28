package sf.极客时间算法训练营_2期.tow_week;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * @Author :
 * @Date: 2021-11-25 18:38
 */
public class 统计优美子数组 {
    public static void main(String[] args) {
        int i = numberOfSubareas(new int[]{2, 1, 1, 2, 1, 1}, 3);
//        int i = numberOfSubareas(new int[]{1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 1}, 3);
        Solution solution = new Solution();
        int i1 = solution.subarraySum(new int[]{1, 1, 2, 1, 1}, 3);
    }

    public static int numberOfSubareas(int[] nums, int k) {
        // 前缀和数组，值是前缀奇数的个数
        int[] s = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            // 1是奇数 0是偶数
            s[i] = s[i - 1] + nums[i - 1] % 2;
        }

        int ans = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length; i++) {
//            if (s[i] - k >= 0) {
//                ans = ans + map.get(s[i] - k);
//            }
//            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
//        }
        int[] count = new int[nums.length + 1];
        count[s[0]]++;
        for (int i = 1; i <= nums.length; i++) {
            if (s[i] - k >= 0) {
                ans = ans + count[s[i] - k];
            }
            count[s[i]]++;
        }
        return ans;
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {

            int n = nums.length;
            int count = 0;
            int[] sum = new int[n]; //前缀和数组
            Map<Integer, Integer> map = new HashMap<>();

            map.put(0, 1); //放入没有前缀和这种特殊情况，见思路一的解释，0这个值出现了1次

            //得到前缀和数组
            sum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }


            //列举子数组
            for (int i = 0; i < n; i++) {
                if (map.containsKey(sum[i] - k))
                    count += map.get(sum[i] - k);
                map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);

            }
            return count;

        }
    }


}
