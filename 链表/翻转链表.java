package sf.链表;

import sf.ListNode;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-10 09:17
 */
public class 翻转链表 {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        reverseList(n1);
        reverseList1(n4);

    }

    /**
     * 双指针
     *
     * 在头结点node遍历的时候此时为1结点
     * next = 1结点.next(2结点)
     * 1结点.next=pre(null)
     * pre = 1结点
     * node = 2结点
     * 进行下一次循环node=2结点
     * next = 2结点.next(3结点)
     * 2结点.next=pre(1结点)=>即完成2->1
     * pre = 2结点
     * node = 3结点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = next;               // cur 访问下一节点
        }
        return pre;
    }
    /**
     * 递归
     *
     */
    public static ListNode reverseList1(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }
    private static ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

}
