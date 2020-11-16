package sf.排序;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-11 10:05
 */
public class 插入 {
    public static void main(String[] args) {
        int[] a = {2, 3, 57, 7, 1};
        insertionSort(a);
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
