package sf.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : 第一个哈希表存储数组中的每个数字的剩余次数，第二个哈希表存储数组中的每个数字作为结尾的子序列的数量
 * @Date: 2020-12-04 10:13
 */
public class 分割数组为连续子序列 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 4, 5, 5};
        boolean possible = isPossible(a);
    }

    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0) + 1;
            countMap.put(x, count);
        }
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int prevEndCount = endMap.getOrDefault(x - 1, 0);
                if (prevEndCount > 0) {
                    countMap.put(x, count - 1);
                    endMap.put(x - 1, prevEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
