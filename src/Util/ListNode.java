package Util;

/**
 * Created by shiyanch on 12/30/16.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public static ListNode toLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int n : nums) {
            ListNode node = new ListNode(n);
            tail.next = node;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode a) {
        while(a != null) {
            System.out.print(a.val+" ");
            a = a.next;
        }
        System.out.println();
    }
}
