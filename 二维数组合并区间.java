package sf;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName : 二维数组合并区间
 * @Description :
 * @Author :
 * @Date: 2020-08-06 14:21
 */
public class 二维数组合并区间 {
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;

        int cnt = 0; // 合并次数
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null; // 清空前者
                    cnt++;
                    break;
                }
            }
        }
        int[][] res = new int[len - cnt][2]; // len - cnt 合并后个数
        int ri = 0;
        for (int[] pair : intervals) {
            if (pair != null) res[ri++] = pair;
        }
        return res;
    }

    public static void main(String[] args) {
        int i1 = 15 & 534;
        int[][] aas = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int[][] merge = merge0(aas);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merge0(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
