package sf.极客时间算法训练营_2期;

import java.util.*;

/**
 * 四数之和 不重复
 */
public class ClazzTwo {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Set<List<Integer>> list = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    //双指针 找剩下的两位
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        if (nums[left] + nums[right] == target - nums[i] - nums[j]) {
                            List<Integer> data = new ArrayList<>();
                            data.add(nums[i]);
                            data.add(nums[j]);
                            data.add(nums[left]);
                            data.add(nums[right]);
                            list.add(data);
                            left++;
                            right--;
                        } else if (nums[left] + nums[right] > target - nums[i] - nums[j]) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
            return new ArrayList<>(list);
        }
    }

}
