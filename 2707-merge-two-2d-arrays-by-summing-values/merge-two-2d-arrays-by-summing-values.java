class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(nums1[i][0] < nums2[j][0]){
                list.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            }
            else if(nums1[i][0] > nums2[j][0]){
                list.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
            else{
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }
        while(i < n){
            list.add(nums1[i++]);
        }
        while(j < m){
            list.add(nums2[j++]);
        }
        return list.toArray(size -> new int[size][]);
    }
}