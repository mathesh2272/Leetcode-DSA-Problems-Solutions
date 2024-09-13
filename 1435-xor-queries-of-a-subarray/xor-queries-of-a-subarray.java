class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pref = new int[n];
        pref[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            pref[i] = pref[i - 1] ^ arr[i];
        }
        n = queries.length;
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = (left == 0 ? 0 : pref[left - 1]) ^ pref[right];
        }
        return ans;
    }
}