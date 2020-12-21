package sf.dp;

/**
 * @Description :
 * @Author :
 * @Date: 2020-12-21 09:31
 */
public class 最少花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] minCost = new int[size];
        minCost[0] = 0;
        minCost[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < size; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i], minCost[i - 2] + cost[i - 1]);
        }
        return minCost[size - 1];
    }

    public static void main(String[] args) {

    }
}
