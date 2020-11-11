package sf.排序;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-11 09:47
 */
public class 冒泡 {
    public static void main(String[] args) {
        int[] a = {2, 3, 57, 7, 1};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
    }
}
