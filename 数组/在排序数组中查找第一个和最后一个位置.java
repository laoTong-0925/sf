package sf.数组;

/**
 * @Description :
 * @Author :
 * @Date: 2020-12-01 09:27
 */
public class 在排序数组中查找第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        int[] ints = searchRange0(a, 8);
        int[] ints1 = searchRange(a, 8);
    }

    // 双指针 特殊情况没处理
    public static int[] searchRange0(int[] nums, int target) {
        int l = -1, length = nums.length, r = -1;
        if (length == 0) {
            return new int[]{l, r};
        }
        for (int i = 0; i < length; i++) {
            if (l != -1 && nums[i] > target) {
                r = i - 1;
                break;
            }
            if (l == -1 && target == nums[i]) {
                l = i;
            }
        }
        return new int[]{l, r};
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
