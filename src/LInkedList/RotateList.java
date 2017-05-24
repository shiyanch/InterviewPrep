package LInkedList;

import Util.ListNode;

/**
 * Created by shiyanch on 12/28/16.
 */
public class RotateList {
    public ListNode rotateRight(ListNode a, int b) {
        ListNode cur = a;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        b %= count;


        ListNode newHead = reverse(a);
        ListNode secHead = newHead;
        while (b-- > 1 && secHead != null) {
            secHead = secHead.next;
        }

        if (secHead == null || secHead.next == null) {
            return newHead;
        }

        System.out.println(secHead.val);
        ListNode temp = secHead;
        secHead = secHead.next;
        temp.next = null;

        ListNode result = reverse(newHead);
        newHead.next = reverse(secHead);
        return result;
    }

    private ListNode reverse(ListNode a) {
        ListNode head = new ListNode(0);

        while (a != null) {
            ListNode cur = a;
            a = a.next;
            cur.next = head.next;
            head.next = cur;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        head.next = a;
        a.next = b;
        b.next = c;

        ListNode res = new RotateList().rotateRight(head, 2);


    }
}
