package sf.剑指.简单;

public class 字符串左旋转 {

    public static String reverseLeftWords(String s, int n) {
        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }
    public static String reverseLeftWords2(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }

    public static void main(String[] args) {
        String substring = "0123".substring(0,2);
        System.out.println(substring);
    }

}
