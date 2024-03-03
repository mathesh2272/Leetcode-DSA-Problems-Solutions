/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        int size = length(head);
        if(size == 1){
            return null;
        }
        if(size == n){
            return head.next;
        }
        size = length(head) - n;
        ListNode rose = head;
        int count = 0;
        while(head != null){
            count++;
            if(count == size){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return rose;
    }
}