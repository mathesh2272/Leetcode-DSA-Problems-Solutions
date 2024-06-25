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
    int sum;
    TreeNode traverse(TreeNode root){
        if(root == null){
            return null;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
        return root;
    }
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        return traverse(root);
    }
}