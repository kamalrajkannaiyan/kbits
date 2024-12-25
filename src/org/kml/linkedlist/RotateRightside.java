package org.kml.linkedlist;

public class RotateRightside {
    public static LinkedNode rotateRight(LinkedNode head, int k) {
        if(head == null || head.next == null) return head;
        LinkedNode curr = head;
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
        LinkedNode newHead = curr;
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
        LinkedNode node = LinkedListUtil.getLinkedList(arr);
        System.out.println(node);
        LinkedNode rotateNode = rotateRight(node, 2);
        System.out.println(rotateNode);
    }
}
