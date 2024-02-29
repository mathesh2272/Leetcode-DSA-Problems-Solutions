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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ind = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int prev = 0;
            if((ind & 1) == 0){
                prev = Integer.MIN_VALUE;
            }
            else{
                prev = Integer.MAX_VALUE;
            }
            while(size-- > 0){
                TreeNode current = queue.poll();
                if((ind & 1) == 0 && ((current.val & 1) == 0 || prev >= current.val)){
                    return false;
                }
                if((ind & 1) == 1 && ((current.val & 1) == 1 || prev <= current.val)){
                    return false;
                }
                prev = current.val;
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            ind++;
        }
        return true;
    }
}