class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int n = intervals.length;
        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            if(end > intervals[i][0]){
                ans++;
                end = Math.min(end, intervals[i][1]);
            }
            else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return ans;
    }
}