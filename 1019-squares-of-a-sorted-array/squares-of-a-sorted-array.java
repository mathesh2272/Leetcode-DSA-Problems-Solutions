class Solution {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(a -> (int)Math.abs(a * a)).sorted().toArray();
    }
}