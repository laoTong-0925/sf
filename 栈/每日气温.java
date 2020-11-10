package sf.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-10 09:49
 */
public class 每日气温 {
    public static void main(String[] args) {
        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(a);
    }

    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
