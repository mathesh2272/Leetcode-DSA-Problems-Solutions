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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] node : descriptions){
            map.put(node[0], new TreeNode(node[0]));
            map.put(node[1], new TreeNode(node[1]));
            set.add(node[1]);
        }
        for(int[] node : descriptions){
            if(node[2] == 1){
                map.get(node[0]).left = map.get(node[1]);
            }
            else{
                map.get(node[0]).right = map.get(node[1]);
            }
        }
        for(int[] node : descriptions){
            if(!set.contains(node[0])){
                return map.get(node[0]);
            }
        }
        return null;
    }
}