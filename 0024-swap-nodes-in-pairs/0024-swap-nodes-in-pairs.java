/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)    return null;
        if(head.next == null)   return head;

        ListNode node = head;
        ListNode newHead = head.next;

        ListNode nodeAhead = node.next.next;
        newHead.next = node;
        ListNode prev = node;
        node.next = nodeAhead;
        node = node.next;
        
        while(node != null && node.next != null) {
            ListNode copyNext = node.next.next;
            ListNode second = node.next;
            prev.next = second;
            node.next = copyNext;
            second.next = node;

            prev = node;
            node = node.next;
        }

        return newHead;
    }
}