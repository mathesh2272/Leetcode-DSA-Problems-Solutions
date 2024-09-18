class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        int zero = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = String.valueOf(nums[i]);
            if(nums[i] == 0){
                zero = zero + 1;
            }
        }
        if(zero == n){
            return "0";
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}