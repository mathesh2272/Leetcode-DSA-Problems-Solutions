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
    private int getLength(ListNode head){
        int n = 0;
        while(head != null){
            n++;
            head = head.next;
        }
        return n;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = getLength(head);
        int split = n / k;
        int remain = n % k;
        ListNode[] ans = new ListNode[k];
        int i = 0;
        while(k-- > 0){
            int size = split;
            if(remain > 0){
                size++;
                remain--;
            }
            ListNode n_head = null;
            ListNode n_tail = null;
            while(size-- > 0){
                if(head == null){
                    return ans;
                }
                if(n_head == null){
                    n_head = n_tail = new ListNode(head.val);
                }
                else{
                    n_tail.next = new ListNode(head.val);
                    n_tail = n_tail.next;
                }
                head = head.next;
            }
            ans[i++] = n_head;
        }
        return ans;
    }
}