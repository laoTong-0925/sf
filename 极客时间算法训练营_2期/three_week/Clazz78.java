package sf.极客时间算法训练营_2期.three_week;

import sf.cath.A;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Clazz78 {
    private static List<List<Integer>> ans = new ArrayList<>();
    private
    static List<Integer> t = new ArrayList<>();


    public static List<List<Integer>> subsets(int[] nums) {
        // 递归 深度优先
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int l, int[] nums) {
        if (l == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        // 选
        t.add(nums[l]);
        dfs(l + 1, nums);
        // 还原
        t.remove(t.size() - 1);
        dfs(l + 1, nums);
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);

    }


}
