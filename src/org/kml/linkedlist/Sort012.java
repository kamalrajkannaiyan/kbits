package org.kml.linkedlist;

public class Sort012 {

    static ListNode sort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zeroCurr = zeroHead;
        ListNode oneCurr = oneHead;
        ListNode twoCurr = twoHead;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = null;
            if(curr.val == 0){
                zeroCurr.next = curr;
                zeroCurr = zeroCurr.next;
            } else if(curr.val == 1){
                oneCurr.next = curr;
                oneCurr = oneCurr.next;
            } else{
                twoCurr.next = curr;
                twoCurr = twoCurr.next;
            }
            curr = next;
        }


        ListNode ans = new ListNode( -1);
        ListNode ansHead = ans;
        if(zeroHead.next != null){
            ans.next = zeroHead.next;
            ans = zeroCurr;
        }
        if(oneHead.next != null){
            ans.next = oneHead.next;
            ans = oneCurr;
        }
        if(twoHead.next != null){
            ans.next = twoHead.next;
        }
        return ansHead.next;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1};
        ListNode node = LinkedListUtil.getLinkedList(arr);
        System.out.println(node);
        ListNode rotateNode = sort(node);
        System.out.println(rotateNode);
    }
}
