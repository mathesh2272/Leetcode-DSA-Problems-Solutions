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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode ans = new ListNode(0);
        ans.next = head;
        map.put(sum, ans);
        while(head != null){
            sum += head.val;
            map.put(sum, head);
            head = head.next;
        } 
        sum = 0;
        head = ans;
        while(head != null){
            sum += head.val;
            head.next = map.get(sum).next;
            head = head.next;
        }
        return ans.next;
    }
}