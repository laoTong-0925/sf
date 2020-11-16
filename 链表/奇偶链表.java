package sf.链表;

import sf.ListNode;

/**
 * @Description :
 * @Author : t-t
 * @Date: 2020-11-13 09:39
 */
public class 奇偶链表 {

    public static void main(String[] args) {
    }

    /**
     * 双指针
     */
    public ListNode merge(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next; // 偶数头
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}
