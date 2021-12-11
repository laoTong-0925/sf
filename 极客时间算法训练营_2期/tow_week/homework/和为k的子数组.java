package sf.极客时间算法训练营_2期.tow_week.homework;

import java.util.HashMap;

/**
 * @Description :
 * @Author :
 * @Date: 2021-11-28 20:04
 */
public class 和为k的子数组 {

    public static void main(String[] args) {
        int i = subarraySum(new int[]{1, 2, 3}, 3);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            // 前缀和
            pre = pre + num;
            if (mp.containsKey(pre - k)) {
                // 符合和为k，存下当前位置前有多少个和为k的子数组
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


}
