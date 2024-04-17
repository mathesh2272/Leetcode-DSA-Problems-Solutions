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
    String min;
    public String helper(TreeNode root, StringBuilder sb){
        if(root == null){
            return min;
        }
        sb.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            String reverse = sb.reverse().toString();
            if(reverse.compareTo(min) < 0){
                min = reverse;
            }
            sb.reverse();
        }
        helper(root.left, sb);
        helper(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
        return min;
    }
    public String smallestFromLeaf(TreeNode root) {
        min = "zzzzzzzz";
        return helper(root, new StringBuilder());
    }
}