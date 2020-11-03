package sf;

/**
 * @Description :上升到高点就下降，没有平  1, 2, 3, 4, 4, 5, 3, 1  false
 * @Author :
 * @Date: 2020-11-03 10:19
 */
public class 有效的山脉数组 {
    public static void main(String[] args) {
        boolean b = get();
        System.out.println(b);
        boolean two = two();
    }

    /**
     * 线性
     */
    private static boolean get() {
        int[] a = {1, 2, 3, 4, 3, 1};
        int n = 0;
        while (n < a.length - 1 && a[n] < a[n + 1])// 找最高点
            n++;
        if (n == 0 || n == a.length - 1)
            return false;
        while (n < a.length - 1 && a[n] > a[n + 1])
            n++;
        return n == a.length - 1;
    }

    /**
     * 双指针
     */
    private static boolean two() {
        int[] A = {1, 2, 3, 4, 4, 5, 3, 1};
        int len = A.length;
        int left = 0;
        int right = len - 1;
        //从左边往右边找，一直找到山峰为止
        while (left < len - 1 && A[left] < A[left + 1])
            left++;
        //从右边往左边找，一直找到山峰为止
        while (right > 0 && A[right - 1] > A[right])
            right--;
        //判断从左边和从右边找的山峰是不是同一个
        return left > 0 && right < len - 1 && left == right;
    }

}
