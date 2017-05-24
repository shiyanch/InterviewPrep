package LInkedList;

import Util.ListNode;

/**
 * Created by shiyanch on 12/31/16.
 */
public class ReverseLinkList {
    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = a;
        ListNode begin = dummy;
        for (int i=0; i<m-1; i++) {
            begin = begin.next;
        }
        if (begin == null) {
            return dummy.next;
        }
        ListNode cur = begin.next;
        ListNode newHead = new ListNode(0);
        ListNode tail = null;
        while (n-- >= m) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = newHead.next;
            newHead.next = temp;
            if (tail == null) {
                tail = temp;
            }
        }

        begin.next = newHead.next;
        tail.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        head.next = n1;
        n1.next = n2;

        ListNode newHead = new ReverseLinkList().reverseBetween(head, 2, 3);
    }
}
