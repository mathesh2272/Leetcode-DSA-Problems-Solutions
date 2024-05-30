class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            int xor_1 = 0;
            for(int j = i + 1 ; j < n ; j++){
                xor_1 ^= arr[j - 1];
                int xor_2 = 0;
                for(int k = j ; k < n ; k++){
                    xor_2 ^= arr[k];
                    if(xor_1 == xor_2){
                        ans++;
                    }
                }
            }
        }       
        return ans;
    }
}