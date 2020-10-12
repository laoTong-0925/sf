package sf;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 三角形最短路径和
 * @Description :
 * @Author :
 * @Date: 2020-07-15 10:28
 */
public class 三角形最短路径和 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(2);

        list2.add(3);
        list2.add(4);

        list3.add(6);
        list3.add(5);
        list3.add(7);

        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);


        int i = minimumTotal(list);
        System.out.println(i);

    }

    public static int minimumTotal(List<List<Integer>> triangle) {//no ac
        int row = triangle.size();//高 底
        int result = 0;
        int index = 0;
        if (row == 1)
            return triangle.get(index).get(index);
        for (int level = 0; level < row - 1; level++) {
            if (level == 0)
                result = triangle.get(level).get(index);
            int t = triangle.get(level + 1).get(index);
            int t1 = triangle.get(level + 1).get(index + 1);
            int min = Math.min(t, t1);
            result += min;
        }
        return result;
    }

    public static int minimumTotal1(List<List<Integer>> triangle) {//ac
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {   //第i行有i+1个数字
                int min = Math.min(minlen[i], minlen[i + 1]);
                int t = triangle.get(level).get(i);
                minlen[i] = min + t;
            }
        }
        return minlen[0];
    }

}
