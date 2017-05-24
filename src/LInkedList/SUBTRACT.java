package LInkedList;

import Util.ListNode;

/**
 * Created by shiyanch on 12/30/16.
 */
public class SUBTRACT {
    public ListNode subtract(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode walker = a;
        ListNode runner = a;
        ListNode prev = walker;

        while (runner != null && runner.next != null) {
            prev = walker;
            runner = runner.next.next;
            walker = walker.next;
        }

        boolean odd = false;
        if(runner != null) {
            walker.next = reverse(walker.next);
            walker = walker.next;
            odd = true;
        }
        else {
            prev.next = reverse(walker);
            walker = prev.next;
        }

        ListNode cur = a;
        while (walker != null) {
            cur.val = walker.val - cur.val;
            cur = cur.next;
            walker = walker.next;
        }

        if (odd) {
            prev = prev.next;
        }

        prev.next = reverse(prev.next);
        return a;
    }

    private ListNode reverse(ListNode a) {
        ListNode dummy = new ListNode(0);
        while(a != null) {
            ListNode node = a;
            a = a.next;
            node.next = dummy.next;
            dummy.next = node;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;

        ListNode newHead = new SUBTRACT().subtract(head);

        while (newHead != null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }
}
