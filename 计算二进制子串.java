package sf;

/**
 * @ClassName : 计算二进制子串
 * @Description :
 * @Author :
 * @Date: 2020-08-10 15:18
 */
public class 计算二进制子串 {

    public static int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
