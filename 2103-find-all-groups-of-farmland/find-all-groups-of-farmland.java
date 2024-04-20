class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        int n = land.length;
        int m = land[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(land[i][j] == 1){
                    int br = 0;
                    int bc = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{land[i][j], i, j});
                    while(!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int ind1 = poll[1];
                        int ind2 = poll[2];
                        br = Math.max(br, ind1);
                        bc = Math.max(bc, ind2);
                        if(ind1 - 1 >= 0 && land[ind1 - 1][ind2] == 1){
                            land[ind1 - 1][ind2] = 0;
                            queue.add(new int[]{land[ind1 - 1][ind2], ind1 - 1, ind2});
                        }
                        if(ind1 + 1 < n && land[ind1 + 1][ind2] == 1){
                            land[ind1 + 1][ind2] = 0;
                            queue.add(new int[]{land[ind1 + 1][ind2], ind1 + 1, ind2});
                        }
                        if(ind2 - 1 >= 0 && land[ind1][ind2 - 1] == 1){
                            land[ind1][ind2 - 1] = 0;
                            queue.add(new int[]{land[ind1][ind2 - 1], ind1, ind2 - 1});
                        }
                        if(ind2 + 1 < m && land[ind1][ind2 + 1] == 1){
                            land[ind1][ind2 + 1] = 0;
                            queue.add(new int[]{land[ind1][ind2 + 1], ind1, ind2 + 1});
                        }
                    }
                    list.add(new int[]{i, j, br, bc});
                }
            }
        }
        return list.stream().toArray(int[][] :: new);
    }
}