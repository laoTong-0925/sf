package sf.链表;

import sf.ListNode;

/**
 * @Description : 判断两链表是否有相交，遍历两个链表 ，遍历长度一样
 * @Author :
 * @Date: 2020-12-21 09:42
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.next : headB;
            hb = hb != null ? hb.next : headA;
        }
        return ha;
    }

}
