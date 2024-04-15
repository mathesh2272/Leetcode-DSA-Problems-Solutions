class Solution {
    public boolean isPrime(int val){
        if(val == 0 || val == 1){
            return false;
        }
        if(val == 2){
            return true;
        }
        for(int i = 2 ; i <= val / 2 ; i++){
            if(val % i == 0){
                return false;
            }
        }
        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int n = nums.length;
        int ind = 0;
        int left = -1;
        int right = -1;
        while(ind < n){
            if(isPrime(nums[ind])){
                if(left == -1){
                    left = ind;
                }
                right = ind;
            }
            ind++;
        }
        return right - left;
    }
}