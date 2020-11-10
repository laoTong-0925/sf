package sf.剑指.简单;

import com.sun.tools.javac.util.StringUtils;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-04 09:26
 */
public class 替换空格 {
    public static void main(String[] args) {
        String s = "   ";
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        System.out.println(res.toString());
    }
}
