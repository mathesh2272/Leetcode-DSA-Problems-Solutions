/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int left = 0;
    public void sum(TreeNode root, char ch) {
        if(root != null) {
            if(ch == 'l' && root.left == null && root.right == null) {
                left += root.val;
            }
            sum(root.left, 'l');
            sum(root.right, 'r');
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        left = 0;
        if(root == null)
            return 0;
        sum(root, 'r');
        return left;
    }
}