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
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        traverse(root.right);
        if(root.left != null || root.right != null){
            if(root.val == 2){
                root.val = root.left.val == 1 ||  root.right.val == 1 ? 1 : 0;
            }
            else{
                root.val = root.left.val == root.right.val && root.left.val == 1 ? 1 : 0;
            }
        }
    }
    public boolean evaluateTree(TreeNode root) {
        traverse(root);
        return root.val == 1 ? true : false;
    }
}