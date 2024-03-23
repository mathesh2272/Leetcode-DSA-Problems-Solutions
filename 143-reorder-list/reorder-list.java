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
    public void reorderList(ListNode head) {
        if(head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        int n = stack.size() - 1;
        while(n-- > 0){
            ListNode pop = stack.pop();
            ListNode next = head.next;
            head.next = pop;
            pop.next = next;
            head = next;
        }
        if(!stack.isEmpty()){
            head.next = stack.pop();
            head.next.next = null;
        }
    }
}