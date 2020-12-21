package sf;

/**
 * @Description : 双指针，只用管0和2，1就会自己被排到中间，2的指针在最后，0的在前面
 * @Author :
 * @Date: 2020-12-21 10:00
 */
public class 颜色分类荷兰国旗 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }



    public static void main(String[] args) {

    }
}
