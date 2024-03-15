class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int n = nums.length;
        int zero = 0;
        boolean flag = false;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                zero++;
            }
            if(zero > 1){
                flag = true;
            }
            mul *= nums[i];
        }
        if(zero == 0){
            for(int i = 0 ; i < n ; i++){
                nums[i] = mul / nums[i];
            }
            return nums;
        }
        if(flag){
            for(int i = 0 ; i < n ; i++){
                nums[i] = 0;
            }
            return nums;
        }
        mul = 1;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                mul *= nums[i];
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                nums[i] = mul;
            } 
            else {
                nums[i] = 0;
            }
        }
        return nums;
    }
}