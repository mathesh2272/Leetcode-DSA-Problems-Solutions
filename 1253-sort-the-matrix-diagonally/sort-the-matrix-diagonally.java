class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            int val = cnt;
            for(int j = m - 1 ; j >= 0 ; j--){
                map.putIfAbsent(val, new LinkedList<>());
                map.get(val).add(mat[i][j]);
                val++;
            }
            cnt++;
        }
        for(int ele : map.keySet()){
            LinkedList<Integer> list = new LinkedList<>(map.get(ele));
            Collections.sort(list);
            map.put(ele, list);
        }
        cnt = 0;
        for(int i = 0 ; i < n ; i++){
            int val = cnt;
            for(int j = m - 1 ; j >= 0 ; j--){
                mat[i][j] = map.get(val).pollFirst();
                val++;
            }
            cnt++;
        }
        return mat;
    }
}