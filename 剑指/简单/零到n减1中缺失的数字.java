package sf.剑指.简单;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class 零到n减1中缺失的数字 {

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * 0 1 2 4 5 6 7 8 9
     * 0 1 2 3 4 5 6 7 8 index
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            if (m == nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] ints = {0, 2, 3, 4, 5};
        int i = missingNumber(ints);
        System.out.println(i);

        Random random = new Random();
        for (int j = 0; j < 20; j++) {
            int index = random.nextInt(tableSize * 2);
            int exTimeSec = getExTimeSec(index);
            System.out.println(index+ " " +exTimeSec);
        }
    }
    private static final int tableSize = (int) TimeUnit.HOURS.toSeconds(1);

    private static int getExTimeSec(Object key) {
        int h = key.hashCode();
        int hash = h ^ (h >>> 16);
        return (tableSize - 1) & hash;
    }

}
