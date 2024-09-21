class Solution {
    public List<Integer> dfs(int val, int n, List<Integer> ans){
        if(val > n){
            return ans;
        }
        ans.add(val);
        dfs(val * 10, n, ans);
        if(val % 10 != 9){
            dfs(val + 1, n, ans);
        }
        return ans;
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        return dfs(1, n, ans);
    }
}