package sf;

/**
 * @ClassName : 重复子字符串
 * @Description :
 * @Author :
 * @Date: 2020-08-24 10:46
 */
public class 重复子字符串 {

    public static void main(String[] args) {
        boolean abab = repeatedSubstringPattern2("adaada");
        System.out.println(abab);
    }

    public static boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern2(String s) {
        System.out.println((s + s).indexOf(s, 1));
        return (s + s).indexOf(s, 1) != s.length();
    }


}
