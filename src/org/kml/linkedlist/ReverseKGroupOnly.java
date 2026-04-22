package org.kml.linkedlist;

public class ReverseKGroupOnly {
    private ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode head, int K)
    {
        ListNode curr = head;
        while (K-- > 1 && curr != null)
        {
            curr = curr.next;
        }
        return curr;
    }

    private ListNode reverseKGroupOnly(ListNode head, int K)
    {
        ListNode curr = head;
        ListNode prevBlockLast = null, newHead = null;
        while (curr != null)
        {
            ListNode kthNode = getKthNode(curr, K);
            if(kthNode == null)
            {
                if (prevBlockLast != null)
                {
                    prevBlockLast.next = curr;
                }
                break;
            }
            ListNode nextBlockHead = kthNode.next;
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
