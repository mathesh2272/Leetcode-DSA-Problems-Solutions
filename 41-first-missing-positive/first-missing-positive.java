class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] rose = new int[n + 1];
        for(int i = 0 ; i < n ; i++){
            if(nums[i] >= 1 && nums[i]<= n){
                rose[nums[i]]++;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            if(rose[i] == 0){
                return i;
            }
        }
        return n + 1;
    }
}