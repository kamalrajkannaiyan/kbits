package org.kml.linkedlist;

public class LinkedListUtil {
    public static LinkedNode getLinkedList(int[] arr)
    {
        LinkedNode preHead = new LinkedNode(-1);
        LinkedNode curr = preHead;
        for(int idx = 0; idx < arr.length; idx++)
        {
            LinkedNode tmp = new LinkedNode(arr[idx]);
            curr.next = tmp;
            curr = curr.next;
        }
        return  preHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        LinkedNode head = getLinkedList(arr);
        System.out.println(head);
    }
}
