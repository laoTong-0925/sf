package sf.极客时间算法训练营_2期.tow_week;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author :
 * @Date: 2021-11-23 22:28
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // 目标值 - 下标
        for (int i = 0; i < nums.length; i++) {
            int tag = target - nums[i];
            if (map.containsKey(nums[i])) {// 假设了只有一种情况就直接返回好了
                Integer index = map.get(nums[i]);
                return new int[]{i, index};
            }
            map.put(tag, i); // 减数 对应的 下标i,后面遍历数组出现tag时就是取下标和当时的i
        }
        return null;
    }
}
