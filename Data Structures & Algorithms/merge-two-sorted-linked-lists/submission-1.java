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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode x = list1, y = list2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (x != null && y != null) {
            if (x.val <= y.val) {
                prev.next = x;  // Append x to the merged list
                x = x.next;     // Move x forward
            } else {
                prev.next = y;  // Append y to the merged list
                y = y.next;     // Move y forward
            }
            prev = prev.next;   // Move the merged tail forward
        }

        // Attach whatever nodes remain
        if (x != null) prev.next = x;
        if (y != null) prev.next = y;

        return dummy.next;
    }
}