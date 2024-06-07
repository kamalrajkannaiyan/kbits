package org.kml.linkedlist;

public class LinkedNode {
    // Data stored in the node
    int data;
    // Pointer to the next
    // node in the list
    LinkedNode next;

    // Constructor with both data
    // and next node as parameters
    LinkedNode(int data, LinkedNode next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    LinkedNode(int data) {
        this.data = data;
        this.next = null;
    }
    @Override
    public String toString()
    {
        return data + ((this.next == null) ? "" : ", " + this.next);
    }
}
