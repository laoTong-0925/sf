package sf.极客时间算法训练营_2期.three_week.homework;

import java.util.*;

/**
 * @Description : 全排列二
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 * @Author :
 * @Date: 2021-12-05 08:33
 */
public class Clazz47 {

        public List<List<Integer>> permuteUnique(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            // 排序
            Arrays.sort(nums);

            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>(len);
            dfs(nums, len, 0, used, path, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; ++i) {
                if (used[i]) {
                    continue;
                }

                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }

                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, used, path, res);
                // 回溯部分
                used[i] = false;
                path.removeLast();
            }
        }

}
