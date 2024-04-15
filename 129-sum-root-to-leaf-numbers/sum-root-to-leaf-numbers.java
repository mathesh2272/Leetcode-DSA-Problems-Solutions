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
    int ans;
    public int traverse(TreeNode root, int sum){
        if(root != null){
            sum = sum * 10 + root.val;
            if(root.left == null && root.right == null){
                ans += sum;
            }
            traverse(root.left, sum);
            traverse(root.right, sum);
        }
        return ans;
    }
    public int sumNumbers(TreeNode root) {
       ans = 0;
       return traverse(root, 0);
    }
}