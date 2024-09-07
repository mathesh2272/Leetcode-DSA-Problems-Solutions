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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean check(TreeNode root, ListNode head){
        if(head == null){
            return true;
        }
        if(root == null || root.val != head.val){
            return false;
        }
        return check(root.left, head.next) || check(root.right, head.next);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null){
            return true;
        }
        if(root == null){
            return false;
        }
        boolean ans = false;
        if(root.val == head.val){
            ans = check(root, head);
        }
        return ans || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}