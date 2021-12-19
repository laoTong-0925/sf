package sf.极客时间算法训练营_2期;

/**
 * 迷宫 dfs
 */
public class ClazzMG {
    private static int[] xn = {1, 0, 0, -1};
    private static int[] yn = {0, 1, -1, 0};


    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        if (row == 0)
            return false;
        int col = maze[0].length;
        if (col == 0)
            return false;

        boolean[][] verify = new boolean[row][col];  //标记哪些节点被遍历过
        return dfs(maze, start[0], start[1], destination, verify, row, col);

    }

    public static boolean dfs(int[][] maze, int x, int y, int[] destination, boolean[][] verify, int row, int col) {
        //已搜索过的值不用继续判断，直接回溯
        if (verify[x][y])
            return false;
        if (x == destination[0] && y == destination[1])
            return true;

        verify[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + xn[i];
            int newY = y + yn[i];
            while (newX >= 0 && newX < row && newY >= 0 && newY < col && maze[newX][newY] == 0) {
                // 只要是空格，就一路往前走，直到碰到墙壁
                newX += xn[i];
                newY += yn[i];
            }
            //结束 while 时，说明当前点是墙壁或者超出边界，往回走一格
            newX -= xn[i];
            newY -= yn[i];

            //这个for循环记录从起点开始能够到达的每一个节点，然后再逐一计算这些节点的每一个节点
            //继续循环各个方向，如果这个停止点是曾经访问过的，则忽略
            if (dfs(maze, newX, newY, destination, verify, row, col))    //继续找当前节点的上下左右节点
                return true;
        }

        return false;
    }

}
