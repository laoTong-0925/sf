//package sf.极客时间算法训练营_2期.one_week;
//
//import java.util.Stack;
//
///**
// * @Description :
// * @Author :
// * @Date: 2021-11-18 21:28
// */
//public class 最小栈 {
//    public static void main(String[] args) {
//
//
//    }
//
//
//    class MinStack {
//        Stack<Integer> stack = new Stack<>();
//        Stack<Integer> minStack = new Stack<>(); // 按顺序入栈，最小在最上面
//
//        public MinStack() {
//        }
//
//        public void push(int val) {
//            minStack.push(val);
//        }
//
//        public void pop() {
//            if (!minStack.empty())
//                minStack.pop();
//        }
//
//        public int top() {
//            if (!minStack.empty())
//
//                minStack.pop();
//        }
//
//        public int getMin() {
//
//        }
//    }
//}
