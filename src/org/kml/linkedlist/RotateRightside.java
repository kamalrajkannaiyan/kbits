package org.kml.linkedlist;

public class RotateRightside {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        int len = 1;
        while(curr.next != null)
        {
            curr = curr.next;
            len++;
        }
        curr.next = head;
        k = k % len;
        k = len - k;
        curr = head;
        for(int rotate = 1; rotate <= k; rotate++)
        {
            curr = curr.next;
        }
        ListNode newHead = curr;
        curr = newHead;
        for(int idx = 1; idx < len; idx++)
        {
            curr = curr.next;
        }
        curr.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode node = LinkedListUtil.getLinkedList(arr);
        System.out.println(node);
        ListNode rotateNode = rotateRight(node, 2);
        System.out.println(rotateNode);
    }
}
