package sf.极客时间算法训练营_2期.four_week;

import sf.cath.A;
import sf.cath.B;

import java.util.*;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Clazz51 {
    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();
    private static boolean[] used;
    // 下面这里使用数组会有越界情况
    private static Map<Integer, Boolean> usedm;
    private static Map<Integer, Boolean> usedp;

    public static void main(String[] args) {
        System.out.println(solveNQueens(3));
    }

    // todo ps:  这题有问题但找不到在哪，老师帮忙看看
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1){
            List<String> objects = new ArrayList<>();
            objects.add("Q");
            res.add(objects);
            return res;
        }
        used = new boolean[n];
        usedm = new HashMap<>();
        usedp = new HashMap<>();
        dfs(0, n);
        for (List<Integer> an : ans) { // 1 3 0 2
            List<String> stringList = new ArrayList<>();
            for (Integer index : an) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == index)
                        stringBuilder.append("Q");
                    else
                        stringBuilder.append(".");
                }
                stringList.add(stringBuilder.toString());
            }
            res.add(stringList);
        }
        return res;
    }

    private static void dfs(int row, int n) {
        // 递归结束条件
        if (row == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!used[j] && !usedm.getOrDefault(row - j, false)
                    && !usedp.getOrDefault(row + j, false)) { // \对角线 row = j / 对角线相差1
                list.add(j);
                // 设置对消情况
                used[j] = true;
                usedm.put(row - j, true);
                usedp.put(row + j, true);

                dfs(row + 1, n);
                // 还原
                usedp.put(row + j, false);
                usedm.put(row - j, false);
                used[j] = false;

                // 这里是要移除最后的 j-for 一直在row里进行的
                list.remove(row);
            }
        }

    }
}
