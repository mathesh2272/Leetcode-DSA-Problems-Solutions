class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for(int i = 0 ; i < n ; i++) {
            arr[nums[i]]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++) {
            if(arr[nums[i]] == 2)
                list.add(nums[i]);
            arr[nums[i]] = 0;
        }
        return list;
    }
}