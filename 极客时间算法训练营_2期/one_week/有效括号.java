package sf.极客时间算法训练营_2期.one_week;

import java.util.Stack;

/**
 * @Description : 栈
 * @Author : 序列、匹配只在结尾发生
 * 最近相关性，只在一个端口
 * @Date: 2021-11-18 20:35
 */
public class 有效括号 {

    public static void main(String[] args) {
        isValid("()");
    }


    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                // 左括号加入栈中
                stack.push(aChar);
            } else {
                // 如果有左括号，栈不会为空
                if (stack.empty() || (aChar == ')' && stack.peek() != '(')) {
                    return false;
                } else if (aChar == '}' && stack.peek() != '{') {
                    return false;
                } else if (aChar == ']' && stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
