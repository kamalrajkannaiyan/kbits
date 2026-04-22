package org.kml.linkedlist;

public class ReverseLGroupRec {
    public static ListNode kReverse(ListNode root, int groupSize) {
        boolean hasKNodes = hasKNodes(root, groupSize);
        if(!hasKNodes) return root;
        ListNode newhead = reverseFirstK(root, groupSize);
        root.next = kReverse(root.next, groupSize);
        return newhead;
    }

    private static boolean hasKNodes(ListNode root, int groupSize) {
        ListNode curr = root;
        while (curr != null && groupSize > 0) {
            curr = curr.next;
            groupSize--;
        }
        return groupSize == 0;
    }

    private static ListNode reverseFirstK(ListNode head, int k) {
        ListNode curr = head, prev = null, next = null;
        while (curr != null && k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        head.next = curr;
        return prev;
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
        head = kReverse(head, 3);

        // Print the reversed linked list
        System.out.println("Reversed Linked List: " + head);
    }

}
