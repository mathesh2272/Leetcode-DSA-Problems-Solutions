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
    StringBuilder st;
    StringBuilder end;
    public TreeNode getAnsc(TreeNode root, int startValue, int destValue){
        if(root == null){
            return null;
        }
        if(root.val == startValue || root.val == destValue){
            return root;
        }
        TreeNode left = getAnsc(root.left, startValue, destValue); 
        TreeNode right = getAnsc(root.right, startValue, destValue); 
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
    public boolean getSt(TreeNode root, int start){
        if(root == null){
            return false;
        }
        if(root.val == start){
            return true;
        }
        boolean left = getSt(root.left, start);
        if(left){
            st.append("U");
            return true;
        }
        boolean right = getSt(root.right, start);
        if(right){
            st.append("U");
            return true;
        }
        return false;
    }
    public boolean getDes(TreeNode root, int destValue){
        if(root == null){
            return false;
        }
        if(root.val == destValue){
            return true;
        }
        boolean left = getDes(root.left, destValue);
        if(left){
            end.append("L");
            return true;
        }
        boolean right = getDes(root.right, destValue);
        if(right){
            end.append("R");
            return true;
        }
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ansc = getAnsc(root, startValue, destValue);
        st = new StringBuilder();
        getSt(ansc, startValue);
        st.reverse();
        end = new StringBuilder();
        getDes(ansc, destValue);
        end.reverse();
        st.append(end);
        return st.toString();
    }
}
