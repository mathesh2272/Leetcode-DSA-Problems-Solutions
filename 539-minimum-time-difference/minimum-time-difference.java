class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] min = new int[n];
        for(int i = 0 ; i < n ; i++){
            String[] arr = timePoints.get(i).split(":");
            int h = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            min[i] = h * 60 + m;
        }
        Arrays.sort(min);
        int ans = Integer.MAX_VALUE;
        for(int i = 1 ; i < n ; i++){
            ans = Math.min(ans, min[i] - min[i - 1]);
        }
        ans = Math.min(ans, 24 * 60 - min[n - 1] + min[0]);
        return ans;
    }
}