class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        for(int ele : nums){
            if(ele >= n){
                hash[n]++;
            }
            else{
                hash[ele]++;
            }
        }
        int ans = 0;
        for(int i = n ; i > 0 ; i--){
            ans += hash[i];
            if(ans == i){
                return i;
            }
        }
        return -1;
    }
}