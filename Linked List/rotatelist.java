// Leetcode problem 61

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
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or k = 0 → nothing to rotate
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count total nodes and find tail
        ListNode curr = head;
        int n = 1; // start at 1 because curr is at head
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        ListNode tail = curr; // last node

        // Step 2: Normalize k
        k = k % n;
        if (k == 0) return head; // rotating by n or multiple of n → same list

        // Step 3: Connect tail to head to make it circular temporarily
        tail.next = head;

        // Step 4: Find new tail: (n - k - 1)th node
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 5: New head is next of newTail
        ListNode newHead = newTail.next;

        // Step 6: Break the circle
        newTail.next = null;

        return newHead;
    }
}
