package LInkedList;

import Util.ListNode;

/**
 * Created by shiyanch on 12/31/16.
 */
public class ReorderList {
    public ListNode reorderList(ListNode a) {
        ListNode b = partition(a);
        ListNode c = reverse(b);
        return merge(a, c);
    }

    private ListNode partition(ListNode a) {
        if (a == null || a.next == null) {
            return null;
        }

        ListNode walker = a;
        ListNode runner = a;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }

        ListNode nextHalf = walker.next;
        walker.next = null;
        return nextHalf;
    }

    private ListNode reverse(ListNode a) {
        ListNode newHead = new ListNode(0);
        while (a != null) {
            ListNode cur = a;
            a = a.next;
            cur.next = newHead.next;
            newHead.next = cur;
        }

        return newHead.next;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1 != null && list2 != null) {
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }

        tail.next = list1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(new ReorderList().reorderList(ListNode.toLinkedList(new int[] {1,2,3,4,5,6,7})));
    }
}
