class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] hash = new int[k];
        for(int i = 0 ; i < n ; i++){
            int val = arr[i] % k;
            if(val < 0){
                val = val + k;
            }
            hash[val]++;
        }
        if(hash[0] % 2 == 1){
            return false;
        }
        for(int i = 1 ; i <= k / 2 ; i++){
            if(hash[i] != hash[k - i]){
                return false;
            }
        }
        return true;
    }
}