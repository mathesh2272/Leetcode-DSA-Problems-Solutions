class Solution {
    boolean flag;
    Set<Integer> set;
    public void check(Map<Integer, LinkedList<Integer>> map, int src, int des) {
        for(int val : map.get(src)) {
            if(val == des) {
                flag = true;
                return;
            }
            if(!set.contains(val)) {
                set.add(val);
                check(map, val, des);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        flag = false;
        set = new HashSet<>();
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        int len = edges.length;
        if(len == 0){
            return true;
        }
        for(int i = 0 ; i < n ; i++){
            map.put(i, new LinkedList<>());
        }
        for(int i = 0 ; i < len ; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        check(map, source, destination);
        return flag;
    }
}