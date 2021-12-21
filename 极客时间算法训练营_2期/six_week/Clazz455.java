package sf.极客时间算法训练营_2期.six_week;

import java.util.Arrays;

public class Clazz455 {

    public int findContentChildren(int[] g, int[] s) {
        //先对胃口值和饼干尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int j = 0; count < g.length && j < s.length; j++) {// 满足人数判断
            // 饼干满足了胃口，小孩向后一个
            if (g[count] <= s[j])
                count++;
        }
        return count;
    }
}
