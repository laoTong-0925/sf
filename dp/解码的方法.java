package sf.dp;

/**
 * @Description : dp
 * 情况：
 * 个数为 0 返回 0
 * 长度为 1 返回 1 排除 0
 * i >= 0 时
 * 当前为0，前一个字符也是0，不能解码，返回0
 * 当前为0，前一个不为0
 * @Author :
 * @Date: 2020-12-03 09:24
 */
public class 解码的方法 {
    public static void main(String[] args) {
        int i = numDecodings0("2341022");
        int i1 = numDecodings("2341022");
        int i2 = 10 - '0';
        int x = 0;
        for (int j = 0; j < 10000; j++) {
            int i3 = j & 16;
            System.out.println(i3);
            if (j!=0)
                x++;
        }
        System.out.println(x);
    }

    public static int numDecodings0(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];//长度为n时，的排列组合种类
        dp[0] = 1;
        dp[1] = 1;
        if (s.length() == 1) return dp[1];
        for (int i = 2; i <= s.length(); i++) {
            int num = Integer.parseInt(String.valueOf(s.charAt(i - 1)));//得到当前数；
            int nums2 = Integer.parseInt(String.valueOf(s.charAt(i - 2)));//得到当前数的前一个数
            if (nums2 + num == 0 || (num == 0 && nums2 > 2)) { // 00出现 >30出现就都不能解码了
                return 0;
            } else if (num == 0 || nums2 == 0) {
                dp[i] = num == 0 ? dp[i - 2] : dp[i - 1];
            } else {
                dp[i] = nums2 * 10 + num > 26 ? dp[i - 1] : dp[i - 2] + dp[i - 1];
            }

        }
        System.out.println();
        return dp[s.length()];
    }


    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) { // -'0' 是为了char转int
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public int numDecodings1(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        int[] dp = new int[len];

        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

}
