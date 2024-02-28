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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode rose = new TreeNode();
        while(!queue.isEmpty()){
            rose = queue.poll();
            if(rose.right != null){
                queue.offer(rose.right);
            }
            if(rose.left != null){
                queue.offer(rose.left);
            }
        }
        return rose.val;
    }
}