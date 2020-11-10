package sf.链表;

import sf.ListNode;

import java.util.Stack;

/**
 * @Description : 栈 或者 线性
 * @Author :
 * @Date: 2020-11-05 10:21
 */
public class 从尾到头打印链表 {

    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().getVal();
        }
        return print;

    }
}
