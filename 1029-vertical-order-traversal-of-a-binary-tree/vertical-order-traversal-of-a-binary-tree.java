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
    List<int[]> list;
    public void traverse(TreeNode root, int point, int level){
        if(root != null){
            list.add(new int[]{point, level, root.val});
            traverse(root.left, point - 1, level + 1);
            traverse(root.right, point + 1, level + 1);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root, 0, 0);
        Collections.sort(list, (a, b) -> {
            return a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0];
        });
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for(int[] arr : list){
            map.putIfAbsent(arr[0], new ArrayList<>());
            map.get(arr[0]).add(arr[2]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> order : map.values()){
            ans.add(order);
        } 
        return ans;
    }
}