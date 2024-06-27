class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = edges.length;
        for(int i = 0 ; i < n ; i++) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
        }
        n = map.size();
        for(int val : map.keySet()) {
            if(map.get(val) == n - 1) {
                return val;
            }
        }
        return 0;
    }
}