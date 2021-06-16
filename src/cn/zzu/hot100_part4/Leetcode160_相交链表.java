package cn.zzu.hot100_part4;


import cn.zzu.hot100_part3.Leetcode234_回文链表;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/11/26 15:10
 */
public class Leetcode160_相交链表 {
    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     *
     * @return
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        return p;
    }


}
