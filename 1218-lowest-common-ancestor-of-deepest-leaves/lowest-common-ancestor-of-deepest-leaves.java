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
    public TreeNode getAnc(TreeNode root, List<TreeNode> list){
        if(root == null){
            return root;
        }
        for(TreeNode tree : list){
            if(root.val == tree.val){
                return root;
            }
        }
        TreeNode left = getAnc(root.left, list);
        TreeNode right = getAnc(root.right, list);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            while(size-- > 0){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
                list.add(poll);
            }
        }
        return getAnc(root, list);
    }
}