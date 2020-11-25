package sf.剑指.简单;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-04 09:38
 */
public class 青蛙跳跳台价 {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int i = get(7);
        System.out.println(i);

    }

    /**
     * 记忆递归
     */
    private static int get(int n) {
        if (n <= 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(n, (get(n - 1) + get(n - 2)));
            return map.get(n);
        }

    }

    /**
     * 规律
     */
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
