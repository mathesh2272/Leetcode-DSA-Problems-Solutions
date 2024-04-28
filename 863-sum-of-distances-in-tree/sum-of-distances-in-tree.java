class Solution {
    public void postorder(int[] ans, int[] count, List<Set<Integer>> graph, int root, int pre, int n) {
        for(int i : graph.get(root)){
            if(i == pre){
                continue;
            } 
            postorder(ans, count, graph, i, root, n);
            count[root] += count[i];
            ans[root] += ans[i] + count[i];
        }
        count[root]++;
    }
    public void preorder(int[] ans, int[] count, List<Set<Integer>> graph, int root, int pre, int n) {
        for(int i : graph.get(root)){
            if(i == pre){
                continue;
            }
            ans[i] = ans[root] - count[i] + n - count[i];
            preorder(ans, count, graph, i, root, n);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new HashSet<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] ans = new int[n];
        int[] count = new int[n];
        postorder(ans, count, graph, 0, -1, n);
        preorder(ans, count, graph, 0, -1, n);
        return ans;
    }
}
