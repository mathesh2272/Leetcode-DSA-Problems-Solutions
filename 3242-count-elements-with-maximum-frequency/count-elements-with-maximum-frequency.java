class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] hash = new int[101];
        int maxfreq = 0;
        for(int i = 0 ; i < n ; i++){
            hash[nums[i]]++;
            maxfreq = Math.max(maxfreq, hash[nums[i]]);    
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(maxfreq == hash[nums[i]]){
                ans++;
            }
        }
        return ans;
    }
}