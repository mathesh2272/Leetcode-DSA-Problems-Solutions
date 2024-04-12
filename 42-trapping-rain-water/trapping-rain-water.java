class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] r = new int[n];
        int[] l = new int[n];
        l[0] = height[0];
        for(int i = 1 ; i < n ; i++){
            l[i] = Math.max(l[i - 1], height[i]);
        }
        r[n - 1] = height[n - 1];
        for (int i = n - 2 ; i >= 0 ; i--){
            r[i] = Math.max(height[i], r[i + 1]);
        }
        for(int i = 0; i < n ; i++){
            sum += (Math.min(l[i], r[i]) - height[i]);
        }
        return sum;
    }
}