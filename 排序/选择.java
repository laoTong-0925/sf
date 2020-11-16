package sf.排序;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-12 16:57
 */
public class 选择 {
    public static void main(String[] args) {

    }

    public static int[] sort(int[] a) {
        int length = a.length;
        if (length == 0)
            return null;
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i; j < length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        return a;
    }
}
