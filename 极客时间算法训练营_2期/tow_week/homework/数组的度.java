package sf.极客时间算法训练营_2期.tow_week.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author :
 * @Date: 2021-11-28 21:19
 */
public class 数组的度 {
    public static void main(String[] args) {
        int shortestSubArray = findShortestSubArray(new int[]{1, 2, 2, 3, 1});
    }

    public static int findShortestSubArray(int[] nums) {
        int l = 0, r = 0, len = nums.length, res = len + 1;
        Map<Integer, Integer> map = new HashMap<>();
        int maxDegree = getDegree(nums); // 度
        while (r < len) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            r++;
            while (map.get(nums[r - 1]) == maxDegree) {
                // 度相同时 划窗找到最小值
                map.put(nums[l], map.get(nums[l]) - 1);
                res = Math.min(res, r - l);
                l++;
            }
        }
        return res;
    }

    public static int getDegree(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            res = Math.max(res, map.get(i));
        }
        return res;
    }

}
