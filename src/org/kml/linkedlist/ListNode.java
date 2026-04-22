package org.kml.linkedlist;

public class ListNode {
    // Data stored in the node
    int val;
    // Pointer to the next
    // node in the list
    ListNode next;
    ListNode child;

    // Constructor with both data
    // and next node as parameters
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    @Override
    public String toString()
    {
        return val + ((this.next == null) ? "" : ", " + this.next);
    }
}
