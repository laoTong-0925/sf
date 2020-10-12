package sf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName : 复制字符
 * @Description :
 * @Author :
 * @Date: 2020-08-04 11:02
 */
public class 复制字符 {

    public static void main(String[] args) throws InterruptedException {
        int i = minSteps(2);
        double d = 1.9;
        int x = (int) d;
        int i1 = pivotIndex();
        System.out.println(i1);
        int[] a = {-1, 3, 5, 6};
        int i2 = searchInsert(a, 0);


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> {
            try {
                for (int j = 0; j < 10; j++) {
                    Thread.sleep(500);
                    System.out.println(j);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(1500);
        executorService.shutdownNow();
        System.out.println(executorService.isShutdown());
    }

    public static int pivotIndex() {
        //[1,7,3,6,5,6] [-1,-1,-1,0,1,1]
        int[] nums = {-1, -1, -1, 0, 1, 1};
        int length = nums.length;
        if (length == 0) return -1;
        for (int i = 0; i < length; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                l = nums[j] + l;
            }
            for (int j = i + 1; j < length; j++) {
                r = nums[j] + r;
            }
            if (l == r)
                return i;
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        int mid;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

    public static int minSteps2(int n) {
        //dp(i) = min(dp(j) + i/j) where 1 <= j < i && i % j == 0.
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    min = Math.min(min, dp[j] + i / j);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }


}
