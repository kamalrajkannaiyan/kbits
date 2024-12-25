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
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        LinkedNode head = LinkedListUtil.getLinkedList(arr);

        // Print the original linked list
        System.out.println("Original Linked List: " + head);

        // Reverse the linked list
        head = kReverse(head, 3);

        // Print the reversed linked list
        System.out.println("Reversed Linked List: " + head);
    }
}