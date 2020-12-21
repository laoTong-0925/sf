package sf.链表;

import sf.ListNode;

/**
 * @Description : 双指针，两个链表都会走相同的路程，他们一定会相遇，在相交处或者最后一个，最后一个时 next都是0直接返回指针就好，null
 * @Author :
 * @Date: 2020-12-10 10:03
 */
public class 两个链表的第一个公共节点 {
    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);

        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(7);
        ListNode intersectionNode = getIntersectionNode(a1, b1);


    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //tempA和tempB我们可以认为是A,B两个指针
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            tempA = tempA == null ? headB : tempA.next;
            //指针tempB同上
            tempB = tempB == null ? headA : tempB.next;
        }
        //tempA要么是空，要么是两链表的交点
        return tempA;
    }

}
