package org.kml.linkedlist;

public class LinkedListUtil {
    public static ListNode getLinkedList(int[] arr)
    {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        for(int idx = 0; idx < arr.length; idx++)
        {
            ListNode tmp = new ListNode(arr[idx]);
            curr.next = tmp;
            curr = curr.next;
        }
        return  preHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = getLinkedList(arr);
        System.out.println(head);
    }
}
