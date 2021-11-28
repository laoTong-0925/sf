package sf.极客时间算法训练营_2期.tow_week;

/**
 * @Description :
 * @Author :
 * @Date: 2021-11-28 12:24
 */
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int[] s = new int[n + 1];
        s[0] = nums[0];
        for (int i = 1; i < n; i++) {
            s[i] = Math.max(s[i - 1] + nums[i], nums[i]);
            res = Math.max(res, s[i]);
        }
        return res;
    }

}
