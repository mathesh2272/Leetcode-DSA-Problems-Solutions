class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mul = 1;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int cnt = 0;
        while(right < n){
            mul *= nums[right];
            while(mul >= k && left <= right){
                mul /= nums[left++];
            }
            cnt += (right - left + 1);
            right++;
        }
        return cnt;
    }
}