package sf.极客时间算法训练营_2期.seven_week;

public class Clazz55 {
    public static boolean canJump(int[] nums) {
        // dp[i] 表示从0能否到达dp[i]
        boolean[] dp = new boolean[nums.length];

        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) { // 步数+位置 >= 目的 表示可以到达
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        boolean b = canJump(new int[]{1, 2, 3, 2, 2, 0, 1});
    }
}
