package sf.极客时间算法训练营_2期.one_week.homework;

import sf.ListNode;

/**
 * @Description :
 * @Author :
 */
public class 合并有序链表 {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode preHead = new ListNode(-1);
            ListNode prev = preHead;
            // 遍历链表
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            prev.next = l1 == null ? l2 : l1;

            return preHead.next;
        }

}
