class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> h = new HashSet<Integer>();
        int[] arr = new int[1001];
        for(int i : nums1)
            arr[i] = 1;
        for(int i : nums2){
            if(arr[i] > 0)
                h.add(i);
        }
        int[] a = new int[h.size()];
        int k = 0;
        for(int e : h)
            a[k++] = e;
        return a;
    }
}