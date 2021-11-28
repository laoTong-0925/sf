package sf.剑指.简单;

import java.util.Stack;

/**
 * 一个栈负责写，一个出
 */
public class 两个栈实现队列 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public 两个栈实现队列() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {


    }
}
