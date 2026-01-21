// Leetcode problem 25

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head; // no need to reverse

        // Dummy node to handle edge cases (head might change)
        ListNode dummy = new ListNode();
        dummy.next = head;

        // prev points to the node before the current k-group
        ListNode prev = dummy;
        ListNode curr = head;

        // Count total nodes
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Reset curr to start
        curr = head;

        // Loop for each k-group
        while (count >= k) {
            // Start reversing k nodes
            ListNode tail = curr; // tail will become the end of reversed group
            // Reverse k nodes
            ListNode prevNode = null; // previous node in this group
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next; // store next node
                curr.next = prevNode;      // reverse link
                prevNode = curr;           // move prevNode forward
                curr = temp;               // move curr forward
            }

            // Connect previous part with reversed group
            prev.next = prevNode; // prevNode is new head of this k-group
            tail.next = curr;     // tail now connects to next part of list

            // Move prev to tail (end of this reversed group)
            prev = tail;

            // Reduce count by k
            count -= k;
        }

        return dummy.next; // new head
    }
}
