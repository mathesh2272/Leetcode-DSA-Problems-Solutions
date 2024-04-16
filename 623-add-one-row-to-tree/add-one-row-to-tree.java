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
    public TreeNode helper(TreeNode root, int val, int depth, int curr){
        if(root == null){
            return root;
        }
        helper(root.left, val, depth, curr + 1);
        helper(root.right, val, depth, curr + 1);
        if(depth - 1 == curr){
            TreeNode tmp = root;
            tmp.left = new TreeNode(val, root.left, null);
            tmp.right = new TreeNode(val, null, root.right);
            return root = tmp;
        }
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val, root, null);
        }
        return helper(root, val, depth, 1);
    }
}