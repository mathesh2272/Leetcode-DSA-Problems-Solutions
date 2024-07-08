class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;
        int size = 1;
        for(int i = 1 ; i < n + k - 1; i++){
            if(colors[(i - 1 + n) % n] != colors[i % n]){
                size++;
            }
            else{
                size = 1;
            }
            if(size >= k){
                ans++;
            }
        }
        return ans;
    }
}