class Solution {
    public int maxGoodNumber(int[] nums) {
        String s1 = Integer.toBinaryString(nums[0]);
        String s2 = Integer.toBinaryString(nums[1]);
        String s3 = Integer.toBinaryString(nums[2]);
        int max = 0;
        max = Math.max(max, Integer.parseInt(s1 + s2 + s3, 2));
        max = Math.max(max, Integer.parseInt(s1 + s3 + s2, 2));
        max = Math.max(max, Integer.parseInt(s2 + s1 + s3, 2));
        max = Math.max(max, Integer.parseInt(s2 + s3 + s1, 2));
        max = Math.max(max, Integer.parseInt(s3 + s1 + s2, 2));
        max = Math.max(max, Integer.parseInt(s3 + s2 + s1, 2));
        return max;
    }
}