class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int n = meetings.length;
        int start = meetings[0][0];
        int end = meetings[0][1];
        for(int i = 1 ; i < n ; i++){
            if(meetings[i][0] <= end){
                end = Math.max(end, meetings[i][1]);
            }
            else{
                if(days >= end - start + 1){
                    days -= end - start + 1;
                }
                else{
                    break;
                }
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }
        if(days >= end - start + 1){
            days -= end - start + 1;
        }
        return days;
    }
}