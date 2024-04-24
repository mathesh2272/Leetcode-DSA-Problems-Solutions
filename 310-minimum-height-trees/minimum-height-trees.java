class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 1){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            ans = new ArrayList<>();
            while(size-- > 0){
                int ele = queue.poll();
                ans.add(ele);
                indegree[ele]--;
                for(int val : graph[ele]){
                    indegree[val]--;
                    if(indegree[val] == 1){
                        queue.add(val);
                    }
                }
            }
        }
        return ans;
    }
}