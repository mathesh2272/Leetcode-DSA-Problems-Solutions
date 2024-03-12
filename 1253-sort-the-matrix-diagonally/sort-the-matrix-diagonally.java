class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            int val = cnt;
            for(int j = m - 1 ; j >= 0 ; j--){
                map.putIfAbsent(val, new PriorityQueue<>());
                map.get(val).add(mat[i][j]);
                val++;
            }
            cnt++;
        }
        cnt = 0;
        for(int i = 0 ; i < n ; i++){
            int val = cnt;
            for(int j = m - 1 ; j >= 0 ; j--){
                mat[i][j] = map.get(val).poll();
                val++;
            }
            cnt++;
        }
        return mat;
    }
}