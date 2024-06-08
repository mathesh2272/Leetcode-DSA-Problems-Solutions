class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n < 2){
            return false;
        }
        int sum = 0;
        int prevrem = 0;
        int currrem = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            currrem = sum % k;
            if(set.contains(currrem)){
                return true;
            }
            set.add(prevrem);
            prevrem = currrem;
        }
        return false;
    }
}