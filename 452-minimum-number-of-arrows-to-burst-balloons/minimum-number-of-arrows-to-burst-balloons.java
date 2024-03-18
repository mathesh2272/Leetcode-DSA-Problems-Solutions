class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 1){
            return 1;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 1;
        int min = Math.min(points[0][1], points[1][1]);
        for(int i = 0; i < n ; i++){
            if(!(points[i][0] <= min && points[i][1] >= min)){
                cnt++;
                if(i + 1 < n){
                    min = Math.min(points[i][1], points[i + 1][1]);
                }
            }
        }
        return cnt;   
    }
}