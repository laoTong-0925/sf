package sf;

import java.util.Arrays;

/**
 * @Description : s = "anagram", t = "nagaram" true
 * @Author :
 * @Date: 2020-11-22 21:59
 */
public class 有效的字母异位词 {
    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars2[i])
                return false;
        }
        return true;
    }
}
