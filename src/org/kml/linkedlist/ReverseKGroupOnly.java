package org.kml.linkedlist;

public class ReverseKGroupOnly {
    private LinkedNode reverse(LinkedNode head)
    {
        LinkedNode curr = head;
        LinkedNode prev = null;
        while (curr != null)
        {
            LinkedNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    private LinkedNode getKthNode(LinkedNode head, int K)
    {
        LinkedNode curr = head;
        while (K-- > 1 && curr != null)
        {
            curr = curr.next;
        }
        return curr;
    }

    private LinkedNode reverseKGroupOnly(LinkedNode head, int K)
    {
        LinkedNode curr = head;
        LinkedNode prevBlockLast = null, newHead = null;
        while (curr != null)
        {
            LinkedNode kthNode = getKthNode(curr, K);
            if(kthNode == null)
            {
                if (prevBlockLast != null)
                {
                    prevBlockLast.next = curr;
                }
                break;
            }
            LinkedNode nextBlockHead = kthNode.next;
            kthNode.next = null;
            reverse(curr);
            if (newHead == null)
            {
                newHead = curr;
            }
            else
            {
                prevBlockLast.next = kthNode;
            }
            prevBlockLast = curr;
            curr = nextBlockHead;
        }
        return head;
    }
}
