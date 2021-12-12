package sf.极客时间算法训练营_2期.four_week.homwork;

/**
 * 被环绕的区域
 */
public class Clazz130 {

    public static void main(String[] args) {
        solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
        public static void solve(char[][] board) {
            if (board == null || board.length == 0) return;
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 从边缘o开始搜索
                    boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                    if (isEdge && board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        public static void dfs(char[][] board, int i, int j) {
            if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
                // board[i][j] == '#' 说明已经搜索过了.
                return;
            }
            board[i][j] = '#';
            dfs(board, i - 1, j); // 上
            dfs(board, i + 1, j); // 下
            dfs(board, i, j - 1); // 左
            dfs(board, i, j + 1); // 右
        }

}
