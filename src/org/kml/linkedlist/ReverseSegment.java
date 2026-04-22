package org.kml.linkedlist;

public class ReverseSegment {
    public static ListNode reverseBetween(ListNode head, int start, int end) {
        if (head == null || start < 0 || start >= end) return head;

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode blockBefore = preHead;
        for (int cnt = 1; cnt < start; cnt++) {
            if (blockBefore.next == null) return head;
            blockBefore = blockBefore.next;
        }

        ListNode blockStart = blockBefore.next;
        ListNode curr = blockStart;
        int reqCnt = end - start + 1;
        ListNode prev = null;
        while (reqCnt-- > 0) {
            if (curr == null) return head;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        blockBefore.next = prev;
        blockStart.next = curr;

        return preHead.next;
    }

    public static void main(String[] args) {
        // Create a linked list with
        // values 5, 4, 3, 7, 9 and 2
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        //int[] arr = {1, 2, 3, 4, 5};
        ListNode head = LinkedListUtil.getLinkedList(arr);

        // Print the original linked list
        System.out.println("Original Linked List: " + head);

        // Reverse the linked list
        head = reverseBetween(head, 2, 4);

        // Print the reversed linked list
        System.out.println("Reversed Linked List: " + head);
    }
}
