class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long ans = 0;
        int start = 0;
        for(int i = 0 ; i < n ; i++){
            start = Math.max(start, customers[i][0]) + customers[i][1];
            ans += (start - customers[i][0]);
        }
        return (double)ans / n;
    }
}