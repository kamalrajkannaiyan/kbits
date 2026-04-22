package org.kml.linkedlist;

public class ReverseKGroup
{

    // Function to reverse a linked list using the 3-pointer approach
    static ListNode reverseLinkedList(ListNode head) {
        // Initialize 'temp' at head of linked list
        ListNode curr = head;
        // Initialize pointer 'prev' to NULL, representing the previous node
        ListNode prev = null;

        // Traverse the list, continue till 'temp' reaches the end (NULL)
        while(curr != null){
            // Store the next node in 'front' to preserve the reference
            ListNode next = curr.next;

            // Reverse the direction of the current node's 'next' pointer to point to 'prev'
            curr.next = prev;

            // Move 'prev' to the current node for the next iteration
            prev = curr;

            // Move 'temp' to the 'front' node advancing the traversal
            curr = next;
        }

        // Return the new head of the reversed linked list
        return prev;
    }

    // Function to get the Kth node from
    // a given position in the linked list
    static ListNode getKthNode(ListNode temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        k -= 1;

        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;

            // Move to the next node
            temp = temp.next;
        }

        // Return the Kth node
        return temp;
    }

    // Function to reverse nodes in groups of K
    static ListNode kReverse(ListNode head, int k) {
        // Initialize a temporary node to traverse the list
        ListNode curr = head;

        // Initialize a pointer to track the last node of the previous group
        ListNode prevLast = null;

        // Traverse through the linked list
        while (curr != null) {
            // Get the Kth node of the current group
            ListNode kThNode = getKthNode(curr, k);

            // If the Kth node is NULL (not a complete group)
            if (kThNode == null) {
                // If there was a previous group, link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = curr;
                }

                // Exit the loop
                break;
            }

            // Store the next node after the Kth node
            ListNode nextBlockNode = kThNode.next;

            // Disconnect the Kth node to prepare for reversal
            kThNode.next = null;

            // Reverse the nodes from
            // temp to the Kth node
            reverseLinkedList(curr);

            // Adjust the head if the reversal
            // starts from the head
            if (curr == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }

            // Update the pointer to the last node of the previous group
            prevLast = curr;

            // Move to the next group
            curr = nextBlockNode;
        }

        // Return the head of the
        // modified linked list
        return head;
    }

    // Function to print the linked list
    static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with
        // values 5, 4, 3, 7, 9 and 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = kReverse(head, 4);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}