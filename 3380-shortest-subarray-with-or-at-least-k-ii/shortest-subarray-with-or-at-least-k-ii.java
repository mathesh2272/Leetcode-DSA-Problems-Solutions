class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = n + 1;
        int[] bit = new int[32];
        while(right < n){
            int value = nums[right];
            char[] binary = Integer.toBinaryString(value).toCharArray();
            int ind = 31;
            int len = binary.length;
            for(int i = len - 1 ; i >= 0 ; i--){
                if(binary[i] == '1'){
                    bit[ind]++;
                }
                ind--;
            }
            int val = 0;
            int pow = 1;
            for(int i = 31 ; i >= 0 ; i--){
                if(bit[i] > 0){
                    val += pow;
                }
                pow *= 2;
            }
            while(left <= right && val >= k){
                ans = Math.min(ans, right - left + 1);
                value = nums[left];
                binary = Integer.toBinaryString(value).toCharArray();
                ind = 31;
                len = binary.length;
                for(int i = len - 1 ; i >= 0 ; i--){
                    if(binary[i] == '1'){
                        bit[ind]--;
                    }
                    ind--;
                }
                val = 0;
                pow = 1;
                for(int i = 31 ; i >= 0 ; i--){
                    if(bit[i] > 0){
                        val += pow;
                    }
                    pow *= 2;
                }
                left++;
            }
            right++;
        }
        return ans == n + 1 ? -1 : ans;
    }
}