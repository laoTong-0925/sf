package sf.剑指.中等;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author :
 * @Date: 2020-12-01 10:14
 */
public class 最长不含重复字符子串Dp {
    public static void main(String[] args) {
        byte[] bs = new byte[31];
        Arrays.fill(bs, (byte) 1);
        String value = String.valueOf(bs);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();//字符，索引
        int res = 0, tmp = 0; // tmp 存每次遍历的结果
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            if (tmp < j - i)
                tmp = tmp + 1;
            else
                tmp = j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

}
