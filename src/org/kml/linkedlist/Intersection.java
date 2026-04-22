package org.kml.linkedlist;

public class Intersection {
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case
        if (headA == null || headB == null) return null;

        // Initialize two pointers to traverse the lists
        ListNode d1 = headA;
        ListNode d2 = headB;

        // Traverse both lists until the pointers meet
        while (d1 != d2) {
            // Move both the pointers by one place
            d1 = d1.next;
            d2 = d2.next;

            // If intersection is found
            if (d1 == d2) return d1;

            // If either of the two pointers reaches end, place at the front of next linked list
            if (d1 == null) d1 = headB;
            if (d2 == null) d2 = headA;
        }

        // Return the intersection node
        return d1;
    }

    static ListNode intersection(ListNode p, ListNode q) {
        ListNode pCurr = p, qCurr = q;

        while (pCurr != qCurr) {
            pCurr = (pCurr == null) ? q : pCurr.next;
            qCurr = (qCurr == null) ? p : qCurr.next;
        }

        return pCurr;
    }
    static ListNode intersection_kml(ListNode p, ListNode q) {
        ListNode pCurr = p, qCurr = q;
        while (pCurr != qCurr) {
            pCurr = pCurr.next;
            if (pCurr == null) pCurr = q;
            qCurr = qCurr.next;
            if (qCurr == null) qCurr = p;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode list1 = LinkedListUtil.getLinkedList(arr);
        System.out.println(list1);
        int[] arr2 = {6, 4, 5};
        ListNode list2 = LinkedListUtil.getLinkedList(arr2);
        System.out.println(list2);

        ListNode ans0 = getIntersectionNode(list1, list2);
        System.out.println(ans0);
        ListNode ans = intersection(list1, list2);
        System.out.println(ans);
    }
}
