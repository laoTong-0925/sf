package sf.排序;

import sf.ListNode;

/**
 * @Description :
 * @Author :
 * @Date: 2020-11-11 10:05
 */
public class 插入 {
    public static void main(String[] args) {
        int[] a = {2, 3, 57, 7, 1};
        insertionSort(a);

        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(8, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(10, n2);
        insertionSortList(n1);
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 链表的插入排序
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
