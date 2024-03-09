class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            set.add(nums1[i]);
        }
        n = nums2.length;
        for(int i = 0 ; i < n ; i++){
            if(set.contains(nums2[i])){
                return nums2[i];
            }
        }
        return -1;
    }
}