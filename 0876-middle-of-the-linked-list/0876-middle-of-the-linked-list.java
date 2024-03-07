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
    public int size(ListNode temp){
        int c = 0;
        while(temp != null){
            c++;
            temp = temp.next;
        }
        return c;
    }
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        int n = size(head);
        int mid = n / 2;
        int c = 0;
        while(head != null){
            c++;
            if(c == mid){
                head = head.next;
                break;
            }
            head=head.next;
        }
        return head;
    }
}