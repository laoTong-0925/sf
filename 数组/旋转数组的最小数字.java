package sf.数组;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-04 10:30
 */
public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
