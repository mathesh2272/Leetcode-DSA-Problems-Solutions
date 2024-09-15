class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        for(int i = 0 ; i < n ; i++){
            hash[nums[i]]++;
        }
        int[] ans = new int[2];
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            if(hash[i] == 2){
                ans[j++] = i;
            }
        }
        return ans;
    }
}