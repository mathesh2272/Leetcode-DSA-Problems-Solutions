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
    public TreeNode getAnc(TreeNode root, Set<TreeNode> set){
        if(root == null){
            return root;
        }
        if(set.contains(root)){
            return root;
        }
        TreeNode left = getAnc(root.left, set);
        TreeNode right = getAnc(root.right, set);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Set<TreeNode> set = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            set = new HashSet<>();
            while(size-- > 0){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
                set.add(poll);
            }
        }
        return getAnc(root, set);
    }
}