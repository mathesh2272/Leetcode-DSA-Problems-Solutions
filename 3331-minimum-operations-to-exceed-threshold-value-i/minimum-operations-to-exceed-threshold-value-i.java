class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int operations = 0;
        for(int num : nums){
            if(num < k){
                operations++;
            } 
            else{
                return operations;
            }
        }
        return operations;
    }
}