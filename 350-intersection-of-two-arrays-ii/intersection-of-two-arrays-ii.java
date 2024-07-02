class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1001];
        int[] hash2 = new int[1001];
        for(int i : nums1){
            hash1[i]++;
        }
        for(int i : nums2){
            hash2[i]++;
        }
        int j = 0;
        for(int i = 0 ; i < 1001 ; i++){
            if(hash1[i] > 0 && hash2[i] > 0){
                int freq = Math.min(hash1[i], hash2[i]);
                while(freq-- > 0){
                    nums1[j++] = i;
                }
            }
        }
        int[] ans = new int[j];
        for(int i = 0 ; i < j ; i++){
            ans[i] = nums1[i];
        }
        return ans;
    }
}