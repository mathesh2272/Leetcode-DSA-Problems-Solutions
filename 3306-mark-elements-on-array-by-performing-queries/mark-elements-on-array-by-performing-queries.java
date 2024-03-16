class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int len = queries.length;
        long[] res = new long[len];
        int[][] arr = new int[n][2];
        long total = 0;
        for(int i = 0 ; i < n ; i++){
            total += nums[i];
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        boolean[] marked = new boolean[n];
        int j = 0;
        for(int i = 0 ; i < len ; i++){
            int index = queries[i][0];
            int k = queries[i][1];
            if(!marked[index]){
                marked[index] = true;
                total -= nums[index];
            }
            while(k > 0 && j < n){
                if(!marked[arr[j][1]]){
                    marked[arr[j][1]] = true;
                    total -= arr[j][0];
                    k--;
                }
                j++;
            }
            res[i] = total;
        }
        return res;
    }
}