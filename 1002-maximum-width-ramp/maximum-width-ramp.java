class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(stack.isEmpty() || stack.peek()[0] > nums[i]){
                stack.push(new int[]{nums[i], i});
            }
        }
        int ans = 0;
        for(int i = n - 1 ; i > -1 ; i--){
            while(!stack.isEmpty() && stack.peek()[0] <= nums[i]){
                ans = Math.max(ans, i - stack.pop()[1]);
            }
        }
        return ans;
    }
}