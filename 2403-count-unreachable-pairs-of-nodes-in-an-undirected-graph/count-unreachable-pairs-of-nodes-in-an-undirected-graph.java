class Solution {
    long count;
    void dfs(List<Integer>[] list, Set<Integer> set, int val){
        if(set.contains(val)){
            return;
        }
        count++;
        set.add(val);
        for(int ele : list[val]){
            dfs(list, set, ele);
        }
    }
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] list = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(set.contains(i)){
                continue;
            }
            count = 0;
            dfs(list, set, i);
            ans = ans + ((n - count) * count);
        }
        return ans / 2;
    }
}