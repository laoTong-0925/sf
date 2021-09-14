package sf.栈;

import java.util.Stack;

/**
 * @Description : 一个栈做队列，一个用来辅助操作，比如 1 2 3一次入A栈，这时候要出第一个，那么
 * @Author :
 * @Date: 2021-07-29 23:07
 */
public class 两个栈实现队列 {
    private static Stack<Integer> setStack = new Stack<>();
    private static Stack<Integer> getStack = new Stack<>();

    public static void main(String[] args) {
        set(2);
    }

    private static Integer del(){
        if (getStack.isEmpty()){
            while (!setStack.isEmpty()){
                getStack.push(setStack.pop());
            }
        }
        if (getStack.isEmpty()){
            return -1;
        } else {
            return getStack.pop();
        }
    }

    private static void set(int e){
        setStack.push(e);
    }

}
