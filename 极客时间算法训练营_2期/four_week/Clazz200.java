package sf.极客时间算法训练营_2期.four_week;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class Clazz200 {
    // 方向数组 南西北东
    private static int[] nr = {0, -1, 0, 1};
    private static int[] nc = {-1, 0, 1, 0};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            char[] chars = grid[r];
            for (int c = 0; c < chars.length; c++) {
                if (chars[c] == '1') {
                    ans++;
                    dfs(grid, r, c);
                }
            }
        }
        return ans;
    }

    private static void dfs(char[][] grid, int r, int c) {
        int rLength = grid.length;
        int cLength = grid[0].length;
        if (r >= rLength || c >= cLength || r < 0 || c < 0 || grid[r][c] != '1') {
            return;
        }

        // 标记块检查过了
        grid[r][c] = '2';
        dfs(grid, r + nr[0], c + nc[0]);
        dfs(grid, r + nr[1], c + nc[1]);
        dfs(grid, r + nr[2], c + nc[2]);
        dfs(grid, r + nr[3], c + nc[3]);
    }

}
