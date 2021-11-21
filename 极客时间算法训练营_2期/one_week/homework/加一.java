package sf.极客时间算法训练营_2期.one_week.homework;

/**
 * @Description : 题目的关键在于从后往前，和有效值时 0~9 往上就要进行进位了
 * @Author :
 * @Date: 2021-11-21 20:25
 */
public class 加一 {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10; // 判断进位与否，如果进位成功了，将i位置赋值为0，不跳出循环，将++操作留到下一位
            if (digits[i] != 0) // 不进位直接返回
                return digits;
        }
        // 这里要考虑到所有的位数都进行了进位，999，那么会出现 000 ，必须在在循环结束时在头加1
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{1, 2, 3});
        int[] ints1 = plusOne(new int[]{9, 9, 9});
        int[] ints2 = plusOne(new int[]{1, 9, 3});
        int[] ints3 = plusOne(new int[]{1, 9, 9});
    }
}
