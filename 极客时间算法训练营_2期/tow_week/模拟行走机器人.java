package sf.极客时间算法训练营_2期.tow_week;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 北 = 0，东 = 1，南 = 2，西 = 3 ，右转转就是加1%4，左转是3个右转（直接-回出负数）
 * <p>
 * ↑ 0
 * 3 ←  → 1
 * ↓ 2
 * <p>
 * 4，-1，5
 * <p>
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * @Author :
 * @Date: 2021-11-23 22:49
 *
 * 思想好牛逼吖
 * 原谅我的中文，好找题目
 */
public class 模拟行走机器人 {

    public static void main(String[] args) {
        // [4,-1,4,-2,4], obstacles = [[2,4]]
        int i = robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}});
        System.out.println(i);
    }

    private static String code(int x, int y) {
        return x + "-" + y;
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        // 北 = 0，东 = 1，南 = 2，西 = 3
        // 方向数组  北 东  南  西
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 障碍点
        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            int[] obstacle = obstacles[i];
            String code = code(obstacle[0], obstacle[1]);
            set.add(code);
        }

        // 起始坐标
        int x = 0, y = 0;
        int dir = 0; // 方向
        int ans = 0;
        for (int command : commands) {
            // 先转向在行走
            if (command == -1) { // 右转
                dir = (dir + 1) % 4;
            } else if (command == -2) { // 左转
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    // 行走预判
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    // 判断障碍点
                    if (set.contains(code(nx, ny))) {
                        // 遇到障碍直接计算
                        continue;
                    } else {
                        // 行走
                        x = nx;
                        y = ny;
                    }
                }
                ans = Math.max(ans, (x * x + y * y));
            }
        }
        return ans;
    }
}
