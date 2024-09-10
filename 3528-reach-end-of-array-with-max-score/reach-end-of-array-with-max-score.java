class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int j = 0;
        long max = nums.get(0);
        int n = nums.size();
        for(int i = 1 ; i < n ; i++){
            long val = nums.get(i);
            if(max < val){
                ans = ans + max * (i - j);
                max = val;
                j = i;
            }
        }
        return j != n - 1 ? ans + max * (n - 1 - j) : ans;
    }
}