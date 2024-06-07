package org.kml.linkedlist;

// Node class represents a
// node in a linked list
public class ReverseKGroupNew
{
    static LinkedNode kReverse(LinkedNode head, int k) {
        LinkedNode curr = head;
        LinkedNode newHead = null, prevBlockTail = null;
        while (curr != null)
        {
            LinkedNode currBlockTail = curr;
            LinkedNode prev = null;
            int counter = 0;
            while (counter < k && curr != null)
            {
                LinkedNode next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
                counter++;
            }
            if (newHead == null)
            {
                newHead = prev;
            }
            else
            {
                prevBlockTail.next = prev;
            }
            prevBlockTail = currBlockTail;
        }
        return newHead;
    }

    // Function to print the linked list
    static void printLinkedList(LinkedNode head) {
        LinkedNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with
        // values 5, 4, 3, 7, 9 and 2
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        head.next.next.next = new LinkedNode(4);
        head.next.next.next.next = new LinkedNode(5);
        head.next.next.next.next.next = new LinkedNode(6);
        head.next.next.next.next.next.next = new LinkedNode(7);
        head.next.next.next.next.next.next.next = new LinkedNode(8);
        head.next.next.next.next.next.next.next.next = new LinkedNode(9);
        head.next.next.next.next.next.next.next.next.next = new LinkedNode(10);

        // Print the original linked list
        System.out.println("Original Linked List: " + head);

        // Reverse the linked list
        head = kReverse(head, 4);

        // Print the reversed linked list
        System.out.println("Reversed Linked List: " + head);
    }
}