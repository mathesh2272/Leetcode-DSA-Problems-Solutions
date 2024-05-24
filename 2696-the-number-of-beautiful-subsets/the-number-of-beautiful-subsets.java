class Solution {
    Set<Integer> set;
    public int track(int[] nums, int ind, int n, int k) {
        if(ind == n) {
            return 1;
        }
        int pick = 0;
        int dont = track(nums, ind + 1, n, k);
        if(!set.contains(nums[ind] - k) && !set.contains(nums[ind] + k)){
            set.add(nums[ind]);
            pick += track(nums, ind + 1, n, k);
            set.remove(nums[ind]);
        }
        return pick + dont;
    }

    public int beautifulSubsets(int[] nums, int k) {
        set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        return track(nums, 0, n, k) - 1;
    }
}
