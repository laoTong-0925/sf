package sf;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-18 09:49
 */
public class 加油站 {
    public static void main(String[] args) {
    }

    /**
     * @param gas  加油站
     * @param cost 到下一个站的油耗
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        //考虑从每一个点出发
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            //当前剩余的油能否到达下一个点
            while (remain - cost[j] >= 0) {
                //减去花费的加上新的点的补给 %是为了成环
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }

}
