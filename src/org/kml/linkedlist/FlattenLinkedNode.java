package org.kml.linkedlist;

public class FlattenLinkedNode {
    static ListNode flatten(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode right = flatten(head.next);
        head.next = null;
        return merge(head, right);
    }

    static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyHead = dummyNode;
        while (node1 != null && node1 != null) {
            if (node1.val <= node2.val) {
                dummyNode.child = node1;
                node1 = node1.child;
            } else {
                dummyNode.child = node2;
                node2 = node2.child;
            }
            dummyNode = dummyNode.child;
        }
        if (node1 != null) {
            dummyNode.child = node1;
        }
        if (node2 != null) {
            dummyNode.child = node2;
        }
        return dummyHead.child;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);

        n1.next = n4;
        n4.next = n7;

        n1.child = n2;
        n2.child = n3;

        n4.child = n5;
        n5.child = n6;

        n7.child = n8;
        n8.child = n9;

        ListNode head = flatten(n1);

        ListNode curr = head;
        while (curr != null) {
            System.out.println("val=" + curr.val +
                    ", next=" + (curr.next != null ? curr.next.val : null) +
                    ", child=" + (curr.child != null ? curr.child.val : null));
            curr = curr.child;
        }
    }
}
