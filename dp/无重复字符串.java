package sf.dp;

import java.util.HashMap;

/**
 * @Description :
 * @Author :
 * @Date: 2020-12-07 09:22
 */
public class 无重复字符串 {
    public static void main(String[] args) {
        int pwwkew = lengthOfLongestSubstring("pwwkew");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // 存的是 字符，位置+1 下一个不重复字符位置
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) { // 重复了 左指针就直接跳到重复的字符后面
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
