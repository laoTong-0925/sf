package sf.链表;

import sf.ListNode;

/**
 * @Description : 双指针，尾指针先移动k位 然后两指针再一起走，尾指针到null了，头指针就是倒数K了   或者使用栈
 * @Author :
 * @Date: 2020-12-10 10:20
 */
public class 倒数第K个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        int t = 0;
        while (fast != null) {
            if (t >= k) slow = slow.next;
            fast = fast.next;
            t++;
        }
        return slow;
    }

    /**
     * 删除前使用一个哨兵节点
     */
    public ListNode del(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode end = pre, start = pre;
        int t = 0;
        while (end.next != null) {
            if (t >= n) start = start.next;
            end = end.next;
            t++;
        }
        start.next = start.next.next;
        return pre.next;
    }

}
