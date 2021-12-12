package sf.极客时间算法训练营_2期.three_week.homework;

import sf.ListNode;

/**
 * @Description : 合并k个升序链表
 * @Author :
 * @Date: 2021-12-05 09:49
 */
public class Clazz23 {

    // 合并两个链表
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return merge2Lists(l1, l2);
    }

}
